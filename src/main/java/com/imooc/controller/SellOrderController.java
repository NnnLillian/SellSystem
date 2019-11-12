package com.imooc.controller;

import com.imooc.dto.OrderDTO;
import com.imooc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.domain.Page;

import java.util.Map;

/**
 * author: Lillian
 * create: 2019-11-12 11:30
 * description: 卖家段订单
 */

@Controller
@RequestMapping("/seller/order")
public class SellOrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 订单列表
     *
     * @param page 第几页, 从1页开始。
     * @param size 一页有多少条数据
     */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                             Map<String, Object> map) {
        PageRequest request = PageRequest.of(page - 1, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(request);
        map.put("orderDTOPage", orderDTOPage);

        return new ModelAndView("order/list", map);
    }
}
