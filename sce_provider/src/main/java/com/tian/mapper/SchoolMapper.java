package com.tian.mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tian.pojo.School;

import java.util.List;

/**
 * @description 针对表【t_school】的数据库操作Mapper
 * @Entity com.tian.pojo.School
 */

public interface SchoolMapper extends BaseMapper<School> {
    /**
     * 根据条件添加
     *
     * @param school
     */
    void insertSelective(School school);

    /**
     * 根据学校代码删除
     */
    void deleteByUniversityCode(String universityCode);

    /**
     * 修改
     */
    void updateSelective(School school);

    /**
     * 查询所有记录
     *
     * @return
     */
    List<School> findAll();

    /**
     * 查询学校代码是否注册
     *
     * @param universityCode
     * @return
     */
    Integer isSchool(String universityCode);

    String queryPasswordByUniversityCode(@Param("universityCode") String universityCode);

}




