package com.tian.controller;

import com.tian.entity.PageResult;
import com.tian.entity.QueryPage;
import com.tian.pojo.User;
import com.tian.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @DubboReference
    private UserService userService;

    @RequestMapping("/user")
    public User queryUserById() {
        return userService.queryUserById();
    }

    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPage queryPage) {
        return userService.queryPage(queryPage);
    }
}
