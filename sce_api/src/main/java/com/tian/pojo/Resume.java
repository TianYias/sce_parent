package com.tian.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING)//转换成json时成为String类型
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