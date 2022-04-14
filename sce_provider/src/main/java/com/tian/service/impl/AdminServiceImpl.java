package com.tian.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tian.mapper.AdminMapper;
import com.tian.pojo.Admin;
import com.tian.service.AdminService;
import org.springframework.stereotype.Service;

/**
* @author JJJJJ
* @description 针对表【t_admin】的数据库操作Service实现
* @createDate 2022-04-01 17:32:11
*/
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin>
    implements AdminService{

}




