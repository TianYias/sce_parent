package com.tian.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 接收前端登录请求数据
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO implements Serializable {
    private String nameNumber;
    private String password;
    private String nickname;
    private String avatar;
    private String token;
    private Integer type;
}
