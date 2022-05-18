package com.tian.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tian.pojo.Enterprise;
import org.apache.ibatis.annotations.Param;

/**
* @description 针对表【t_enterprise】的数据库操作Mapper
*/
public interface EnterpriseMapper extends BaseMapper<Enterprise> {

    Integer isEnterprise(@Param("id") Long id);

    String queryPasswordById(@Param("id") Long id);
}




