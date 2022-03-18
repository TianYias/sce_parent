package com.tian.service;

import com.tian.entity.PageResult;
import com.tian.entity.QueryPage;
import com.tian.pojo.User;

public interface UserService {

    public User queryUserById ();

    /**
     * 分页查询
     * @param queryPage 查询条件
     */
    public PageResult queryPage(QueryPage queryPage);
}
