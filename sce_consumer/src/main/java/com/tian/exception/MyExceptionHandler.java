package com.tian.exception;

import com.tian.entity.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MyExceptionHandler {

    /**
     * 如果抛出的是ServiceException异常，则调用该方法
     *
     * @param serviceException
     * @return
     */

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public Result handle(ServiceException serviceException) {
        return Result.error(serviceException.getConstants());
    }
}
