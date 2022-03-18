package com.tian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tian.entity.PageResult;
import com.tian.entity.QueryPage;
import com.tian.mapper.UserMapper;
import com.tian.pojo.User;
import com.tian.service.UserService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;


@DubboService
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryUserById() {
        User user = new User(1, "123", "男");
        return user;
    }

    @Override
    public PageResult queryPage(QueryPage queryPage) {
        Page<User> page = new Page<>(queryPage.getCurrentPage(), queryPage.getPageSize());
        LambdaQueryWrapper<User> userQueryWrapper = new LambdaQueryWrapper<>();
        userQueryWrapper
                .eq(queryPage.getQueryString() != null, User::getSex, queryPage.getQueryString())
                .or()
                .eq(queryPage.getQueryString() != null, User::getName, queryPage.getQueryString());
       /* QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        if (queryPage.getQueryString() != null) {
            userQueryWrapper.eq("sex", queryPage.getQueryString());
        }*/
        userMapper.selectPage(page, userQueryWrapper);
        return new PageResult(page.getTotal(), page.getRecords());
    }
}
