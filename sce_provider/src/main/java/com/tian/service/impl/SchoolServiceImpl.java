package com.tian.service.impl;

import com.tian.mapper.SchoolMapper;
import com.tian.pojo.School;
import com.tian.service.SchoolService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @description 针对表【t_school】的数据库操作Service实现
 */
@DubboService
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolMapper schoolMapper;

    @Override
    public List<School> findAll() {
        return schoolMapper.findAll();
    }
}




