package com.imooc.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

//该注解将数据库映射为对象
@Entity
//该注解表示动态更新
@DynamicUpdate
//该注解来自于Lombok，其中包含了get/set方法
@Data
public class ProductCategory {
//    类目Id
//    @Id 标注用于声明一个实体类的属性映射为数据库的主键列。
//    @GeneratedValue 用于标注主键的生成策略(默认为采用数据库ID自增长的方式来自增主键字段)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
//    类目名字
    private String categoryName;
//    类目编号
    private Integer categoryType;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
