package com.imooc.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * author: Lillian
 * create: 2019-07-13 12:10
 * description: 进行表单验证
 */
@Data
public class OrderForm {

    // 买家姓名
    @NotEmpty(message = "姓名必填")
    private String name;

    // 买家手机号
    @NotEmpty(message = "手机号必填")
    private String phone;

    // 买家地址
    @NotEmpty(message = "地址必填")
    private String address;

    // 买家微信openid
    @NotEmpty(message = "openid必填")
    private String openid;

    // 购物车
    @NotEmpty(message = "购物车不能为空")
    private String items;
}