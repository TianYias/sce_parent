package com.tian.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class PageResult implements Serializable {

    private String code;//返回提示码
    private Long total;//总记录数
    private List rows;//当前页结果
}
