package com.imooc.utils;

import java.util.Random;

/**
 * @author: Lillian
 * @create: 2019-07-12 21:17
 */
public class KeyUtil {
    /**
     * @Description: 生成唯一的主键(订单编号, 订单详情编号)
     * @return: 时间+随机数
     * @Author: Lillian
     * @Date: 2019-07-12 21:18
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();

        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}


