package com.tian.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tian.pojo.School;

import java.util.List;

/**
* @description 针对表【t_school】的数据库操作Mapper
* @Entity com.tian.pojo.School
*/

public interface SchoolMapper extends BaseMapper<School> {
    List<School> findAll();
}




