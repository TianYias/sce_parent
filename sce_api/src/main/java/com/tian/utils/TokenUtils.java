package com.tian.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;


public class TokenUtils {

    /**
     * 定义过期时间
     */
    private static final long EXPIRE_TIME = 2 * 60 * 60 * 1000;

    /**
     * 生成token
     * @param userId
     * @param sign
     * @return
     */
    public static String genToken(String userId, String sign) {
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        return JWT.create().withAudience(userId) // 将 user id 保存到 token 里面，作为荷载
                .withExpiresAt(date) //两小时后token过期
                .sign(Algorithm.HMAC256(sign)); // 以 password 作为 token 的密钥
    }
}
