package com.tian.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @TableName t_admin
 */
@Data
public class Admin implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 名字
     */
    private String name;

    /**
     * 密码
     */
    private String password;
}