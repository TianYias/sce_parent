package com.tian.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public enum Constants implements Serializable {

    CODE_200("200","成功"),
    CODE_201("201","失败"),
    CODE_250("250","查询成功"),
    CODE_400("400","参数不足"),
    CODE_401("401","请登录"),
    CODE_402("402","验证失败"),
    CODE_403("403","用户权限错误"),
    CODE_405("405","图片上传失败"),
    CODE_500("500","系统错误"),
    CODE_600("600","用户名或密码错误"),

    ;

    private String code;
    private String msg;
}
