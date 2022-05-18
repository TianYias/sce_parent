package com.tian.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tian.pojo.Student;
import org.apache.ibatis.annotations.Param;

/**
* @description 针对表【t_student】的数据库操作Mapper
* @Entity com.tian.pojo.Student
*/
public interface StudentMapper extends BaseMapper<Student> {
    Integer isStudent(@Param("id") Long id);

    String queryPasswordById(@Param("id") Long id);
}




