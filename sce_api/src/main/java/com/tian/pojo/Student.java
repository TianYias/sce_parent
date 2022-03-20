package com.tian.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName t_student
 */
@Data
public class Student implements Serializable {
    /**
     * 学生id
     */
    private Long id;

    /**
     * 学号
     */
    private String studentNumber;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户名
     */
    private String name;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 年级
     */
    private String grade;

    /**
     * 专业
     */
    private Integer major;

    /**
     * 电话
     */
    private String phone;

    /**
     * 院校代码
     */
    private String universityCode;

    /**
     * 照片
     */
    private String img;

    /**
     * 简历id
     */
    private Long resumeId;

}