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
    /**
     * 号码
     */
    private String nameNumber;
    /**
     * 密码
     */
    private String password;
    /**
     * 别名
     */
    private String nickname;
    /**
     * 图片
     */
    private String avatar;
    /**
     * token
     */
    private String token;
    /**
     * 类型
     */
    private Integer type;
}
