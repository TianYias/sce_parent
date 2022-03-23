package com.tian.controller;

import cn.hutool.core.util.StrUtil;
import com.tian.dto.LoginDTO;
import com.tian.entity.Constants;
import com.tian.entity.Result;
import com.tian.service.LoginService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @DubboReference
    private LoginService loginService;

    @RequestMapping("/login")
    public Result login(@RequestBody LoginDTO loginDTO){

        if (StrUtil.isBlank(loginDTO.getNameNumber()) || StrUtil.isBlank(loginDTO.getPassword())){
            return Result.error(Constants.CODE_400);
        }
        return loginService.login(loginDTO);
    }
}
