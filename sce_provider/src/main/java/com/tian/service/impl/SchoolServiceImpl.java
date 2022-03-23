package com.tian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tian.entity.PageResult;
import com.tian.entity.QueryPage;
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
    public void insert(School school) {
        //schoolMapper.insertSelective(school);
        schoolMapper.insert(school);
    }

    /*@Override
    public Result login(LoginDTO loginDTO) {
        QueryWrapper<School> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .and(i -> i
                        .eq("university_code", loginDTO.getNameNumber())
                        .or()
                        .eq("name", loginDTO.getNameNumber()))
                .eq("password", loginDTO.getPassword());
        //return schoolMapper.exists(queryWrapper);
        School school;
        try {
            school = schoolMapper.selectOne(queryWrapper);
        } catch (Exception e) {
            return Result.error(Constants.CODE_500);
        }
        if (school != null) {
            *//*LoginDTO dto = new LoginDTO(
                    school.getUniversityCode(),
                    school.getPassword(),
                    school.getName(),
                    school.getSchoolBadge(),
                    null);*//*
            //设置别名
            loginDTO.setNickname(school.getName());
            //设置头像
            loginDTO.setAvatar(school.getSchoolBadge());
            //设置token
            loginDTO.setToken(TokenUtils.genToken(loginDTO.getNameNumber(), loginDTO.getPassword()));
            return Result.success(loginDTO);
        } else {
            return Result.error(Constants.CODE_600);
        }
    }*/

    @Override
    public void delete(String universityCode) {
        schoolMapper.deleteByUniversityCode(universityCode);
    }

    @Override
    public void update(School school) {
        schoolMapper.updateSelective(school);
    }

    @Override
    public List<School> findAll() {
        return schoolMapper.findAll();
    }

    @Override
    public PageResult findPage(QueryPage queryPage) {
        Page<School> schoolPage = new Page<>(queryPage.getCurrentPage(), queryPage.getPageSize());
        QueryWrapper<School> schoolQueryWrapper = new QueryWrapper<>();
        schoolQueryWrapper
                .like(queryPage.getQueryString() != null && queryPage.getQueryString() != "",
                        "name", queryPage.getQueryString())
                .or()
                .like(queryPage.getQueryString() != null && queryPage.getQueryString() != "",
                        "university_code", queryPage.getQueryString());
        schoolMapper.selectPage(schoolPage, schoolQueryWrapper);
        return new PageResult(schoolPage.getTotal(), schoolPage.getRecords());
    }

    @Override
    public boolean inSchool(String universityCode) {
        if (schoolMapper.isSchool(universityCode) != 0) {
            return true;
        }
        return false;
    }

}




