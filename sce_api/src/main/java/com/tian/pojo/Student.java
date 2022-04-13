package com.tian.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName t_student
 */
@Data
public class Student implements Serializable {
    /**
     * 学生id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)//转换成json时成为String类型
    private Long id;

    /**
     * 学号
     */
    private String studentNumber;

    /**
     * 密码
     */
    //@JsonIgnore//禁止密码转成json格式传到客户端
    private String password;

    /**
     * 用户名
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

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
    private String major;

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