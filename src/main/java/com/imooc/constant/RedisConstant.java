package com.imooc.constant;

/**
 * redis常量
 * author: Lillian
 * create: 2019-11-15 17:24
 */
public interface RedisConstant {

    String TOKEN_PREFIX  = "token_%s";

    Integer EXPIRE = 7200; // 2 hours
}
