package com.imooc.repository;

import com.imooc.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
    //   该方法通过买家的OpenID将其订单分页返回。 如果没有pageable，就会将所有的订单信息都返回，导致订单量过于大
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenId, Pageable pageable);
}
