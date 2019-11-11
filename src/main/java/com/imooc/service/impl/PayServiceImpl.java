package com.imooc.service.impl;

import com.imooc.dto.OrderDTO;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.service.PayService;
import com.imooc.utils.JsonUtil;
import com.imooc.utils.MathUtil;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * author: Lillian
 * create: 2019-09-22 16:19
 * description: 实现支付接口
 */
@Service
@Slf4j
public class PayServiceImpl implements PayService {
    private static final String ORDER_NAME = "微信点单订餐";

    @Autowired
    private BestPayServiceImpl bestPayService;

    @Autowired
    private OrderServiceImpl orderService;

    @Override
    public PayResponse create(OrderDTO orderDTO) {
        PayRequest payRequest = new PayRequest();
        payRequest.setOpenid(orderDTO.getBuyerOpenid());
        payRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        payRequest.setOrderId(orderDTO.getOrderId());
        payRequest.setOrderName(ORDER_NAME);
        payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        log.info("【微信支付】，发起支付，request={}", JsonUtil.toJson(payRequest));

        PayResponse payResponse = bestPayService.pay(payRequest);
        log.info("【微信支付】，发起支付，response={}", JsonUtil.toJson(payResponse));
        return payResponse;
    }

    @Override
    public PayResponse notify(String notifyData) {
//        1. 验证签名（验证一下这个签名是不是真正来自于微信，不然别人模拟一个微信验证请求，我们也会傻fufu的通过）
//        2. 支付的状态（虽然会得到异步通知，但是消息的内容不一定是支付成功，也有失败等多种情况）
//        3. 支付金额（有可能程序错误，导致微信回调之后的金额不够统一，所以需要校验金额）
//        4. 付款人（下单人 == 支付人）（根据业务需要确定下单人和支付人是否一直，所以根据情况可以校验确认一下）
        PayResponse payResponse = bestPayService.asyncNotify(notifyData);
        log.info("【微信支付】异步通知，payResponse={}", payResponse);

        // 修改订单支付状态
        // 1 先查询一下当前订单
        OrderDTO orderDTO = orderService.findOne(payResponse.getOrderId());
        // 2 判断订单是否存在
        if (orderDTO == null) {
            log.error("【微信支付】异步通知，订单不存在。orderId={}", payResponse.getOrderId());
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        // 3 判断金额是否一致(因为很多判断中，由于精度的不同，会判断两个金额不一致，比如0.10和0.1；所以采用相减的方式，写在util工具类中)
        if (!MathUtil.equals(payResponse.getOrderAmount(), orderDTO.getOrderAmount().doubleValue())) {
            log.error("【微信支付】异步通知，订单不存在。orderId={}， 微信通知金额={}， 系统金额 ={}", payResponse.getOrderId(), payResponse.getOrderAmount(), orderDTO.getOrderAmount());
            throw new SellException(ResultEnum.WXPAY_NOTIFY_MONEY_VERIFY_ERROR);
        }
        // 4 2、3步都通过后，再修改订单状态
        orderService.paid(orderDTO);

        return payResponse;
    }
}
