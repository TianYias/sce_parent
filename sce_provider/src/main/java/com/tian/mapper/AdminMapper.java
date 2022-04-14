package com.tian.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tian.pojo.Admin;
import org.apache.ibatis.annotations.Param;

/**
* @author JJJJJ
* @description 针对表【t_admin】的数据库操作Mapper
* @createDate 2022-04-01 17:32:11
* @Entity com.tian.pojo.Admin
*/
public interface AdminMapper extends BaseMapper<Admin> {
    String queryPasswordById(@Param("id") Integer id);
}




