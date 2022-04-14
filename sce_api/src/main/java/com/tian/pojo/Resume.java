package com.tian.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName t_resume
 */
@Data
public class Resume implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 学生id
     */
    private Long studentId;

    /**
     * 简历内容
     */
    private String content;

}