package com.imooc.form;

import lombok.Data;

/**
 * author: Lillian
 * create: 2019-11-13 20:15
 * description: 商品种类表单
 */
@Data
public class CategoryForm {
    private Integer categoryId;
    //    类目名字
    private String categoryName;
    //    类目编号
    private Integer categoryType;
}
