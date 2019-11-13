package com.imooc.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * author: Lillian
 * create: 2019-11-13 18:54
 * description: 修改/新增商品内容
 */
@Data
public class ProductForm {
    private String productId;
    //    名字
    private String productName;
    //    单价
    private BigDecimal productPrice;
    //    库存
    private Integer productStock;
    //    描述
    private String productDescription;
    //    小图
    private String productIcon;
    //    状态，0正常，1下架
    private Integer productStatus;
    //    类目编号
    private Integer categoryType;
}
