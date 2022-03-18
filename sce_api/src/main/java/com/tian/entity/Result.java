package com.tian.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Result implements Serializable {

    private boolean flag;//执行结果，true为执行成功 false为执行失败
    private String message;//返回提示信息，主要用于页面提示信息
    private Object data;//返回数据

    public Result(boolean flag, String message) {
        super();
        this.flag = flag;
        this.message = message;
    }
}