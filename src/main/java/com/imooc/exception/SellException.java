package com.imooc.exception;

import com.imooc.enums.ResultEnum;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * @author: Lillian
 * @create: 2019-07-12 20:55
 */
public class SellException extends RuntimeException {
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
