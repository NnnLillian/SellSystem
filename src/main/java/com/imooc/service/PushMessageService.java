package com.imooc.service;

import com.imooc.dto.OrderDTO;

/**
 * author: Lillian
 * create: 2019-11-20 16:16
 */
public interface PushMessageService {

    /**
     * 订单状态变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
