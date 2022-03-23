package com.tian.exception;

import com.tian.entity.Constants;

import java.io.Serializable;

/**
 * 自定义异常
 */
public class ServiceException extends RuntimeException implements Serializable{

    private Constants constants;

    public ServiceException(Constants constants) {
        super(constants.getMsg());
        this.constants = constants;
    }

    public Constants getConstants() {
        return constants;
    }
}
