package com.tian.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tian.pojo.User;
import org.apache.ibatis.annotations.Param;

//@Repository
public interface UserMapper extends BaseMapper<User> {

    User queryById(@Param("id") Integer id);
}
