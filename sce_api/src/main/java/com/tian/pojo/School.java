package com.tian.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName t_school
 */
@Data
public class School implements Serializable {
    /**
     * 院校代码
     */
    private String universityCode;
    /**
     * 学校名字
     */
    private String name;
    /**
     * 密码
     */
    @JsonIgnore
    private String password;

    /**
     * 电话
     */
    private String phone;

    /**
     * 所在地
     */
    private Integer location;

    /**
     * 校徽
     */
    private String schoolBadge;

    /**
     * 简介
     */
    private String introduce;

}