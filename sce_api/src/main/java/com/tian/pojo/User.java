package com.tian.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class User implements Serializable {

    private Integer id;
    private String name;
    private String sex;
    /*@JsonIgnore//不让转换成Json
    private Long version;*/
}
