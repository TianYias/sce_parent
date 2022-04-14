package com.tian.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tian.pojo.Resume;
import org.apache.ibatis.annotations.Param;

/**
* @author JJJJJ
* @description 针对表【t_resume】的数据库操作Mapper
* @createDate 2022-04-14 17:15:53
* @Entity com.tian.pojo.Resume
*/
public interface ResumeMapper extends BaseMapper<Resume> {

    Integer isResume(@Param("id") Long id);

}




