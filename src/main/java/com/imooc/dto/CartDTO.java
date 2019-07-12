package com.imooc.dto;

import lombok.Data;

/**
 * @author: Lillian
 * @create: 2019-07-12 21:35
 * @description: 购物车
 */

@Data
public class CartDTO {

    /*商品ID*/
    private String productId;

    /*商品数量*/
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
