package com.imooc.service;

import com.imooc.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    ProductInfo findOne(String productId);

//    查询所有在架商品列表
    List<ProductInfo> findUpAll();
//    管理员查找时用Pageable将商品栏目分页
    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

//    增加库存

//    减少库存

}
