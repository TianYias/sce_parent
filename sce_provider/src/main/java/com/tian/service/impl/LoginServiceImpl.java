package com.tian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tian.dto.LoginDTO;
import com.tian.entity.Constants;
import com.tian.entity.Result;
import com.tian.mapper.SchoolMapper;
import com.tian.pojo.School;
import com.tian.service.LoginService;
import com.tian.utils.TokenUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

@DubboService
public class LoginServiceImpl implements LoginService {

    @Autowired
    private SchoolMapper schoolMapper;

    @Override
    public Result login(LoginDTO loginDTO) {

        switch (loginDTO.getType()) {
            case 1: {
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
                    /*LoginDTO dto = new LoginDTO(
                    school.getUniversityCode(),
                    school.getPassword(),
                    school.getName(),
                    school.getSchoolBadge(),
                    null);*/
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
            }
            case 2:
            case 3:
            case 4:
        }
        return null;
    }

}
