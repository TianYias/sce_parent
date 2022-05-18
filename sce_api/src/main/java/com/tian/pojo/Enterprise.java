package com.tian.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName t_enterprise
 */
@Data
public class Enterprise implements Serializable {
    /**
     * id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)//转换json时 转换成String类型
    private Long id;

    /**
     * 工商编码
     */
    private String businessCode;

    /**
     * 公司名称
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 电话
     */
    private String phone;

    /**
     * 地址
     */
    private String address;

    /**
     * 照片
     */
    private String img;

    /**
     * 介绍
     */
    private String introduce;

}