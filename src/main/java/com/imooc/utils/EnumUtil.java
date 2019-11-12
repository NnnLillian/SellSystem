package com.imooc.utils;

import com.imooc.enums.CodeEnum;

/**
 * author: Lillian
 * create: 2019-11-12 12:59
 * description: 枚举工具类，通过code得到相应的value
 */
public class EnumUtil {
    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
