package com.tian.service;

import com.tian.pojo.School;

import java.util.List;

/**
* @description 针对表【t_school】的数据库操作Service
*/
public interface SchoolService {
    public List<School> findAll();
}
