package com.tian.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 接口统一返回包装类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result implements Serializable {

    private String code;//执行结果，true为执行成功 false为执行失败
    private String message;//返回提示信息，主要用于页面提示信息
    private Object data;//返回数据

    public Result(Constants constants, Object data) {
        this.code = constants.getCode();
        this.message = constants.getMsg();
        this.data = data;

    }

    public static Result success() {
        return new Result(Constants.CODE_200,null);
    }

    public static Result success(Object data) {
        return new Result(Constants.CODE_200,data);
    }

    public  static Result error(){
        return new Result(Constants.CODE_500, null);
    }

    public  static Result error(Constants constants){
        return new Result(constants, null);
    }
}
