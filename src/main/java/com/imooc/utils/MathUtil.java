package com.imooc.utils;

/**
 * author: Lillian
 * create: 2019-10-28 10:48
 * description: 判断金额是否一致
 */
public class MathUtil {
    private static final Double Money_Range = 0.01;

    public static Boolean equals(Double d1, Double d2){
        Double result =  Math.abs(d1 - d2);
        if (result < Money_Range){
            return true;
        } else {
            return false;
        }
    }
}
