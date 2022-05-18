package com.tian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tian.dto.LoginDTO;
import com.tian.entity.Constants;
import com.tian.entity.Result;
import com.tian.mapper.AdminMapper;
import com.tian.mapper.EnterpriseMapper;
import com.tian.mapper.SchoolMapper;
import com.tian.mapper.StudentMapper;
import com.tian.pojo.Admin;
import com.tian.pojo.Enterprise;
import com.tian.pojo.School;
import com.tian.pojo.Student;
import com.tian.service.LoginService;
import com.tian.utils.TokenUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

@DubboService
public class LoginServiceImpl implements LoginService {

    @Autowired
    private SchoolMapper schoolMapper;

    @Autowired
    private EnterpriseMapper enterpriseMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Result login(LoginDTO loginDTO) {
        switch (loginDTO.getType()) {
            case 1:
                //学校登录
                QueryWrapper<School> schoolQueryWrapper = new QueryWrapper<>();
                schoolQueryWrapper
                        .and(i -> i
                                .eq("university_code", loginDTO.getNameNumber())
                                .or()
                                .eq("name", loginDTO.getNameNumber()))
                        .eq("password", loginDTO.getPassword());
                //return schoolMapper.exists(schoolQueryWrapper);
                School school;
                try {
                    school = schoolMapper.selectOne(schoolQueryWrapper);
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
                    //设置号码
                    loginDTO.setNameNumber(school.getUniversityCode());
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
            case 2:
                //企业登录
                QueryWrapper<Enterprise> enterpriseQueryWrapper = new QueryWrapper<>();
                enterpriseQueryWrapper
                        .and(i -> i
                                .eq("id", loginDTO.getNameNumber())
                                .or()
                                .eq("name", loginDTO.getNameNumber()))
                        .eq("password", loginDTO.getPassword());
                Enterprise enterprise;
                try {
                    enterprise = enterpriseMapper.selectOne(enterpriseQueryWrapper);
                } catch (Exception e) {
                    return Result.error(Constants.CODE_500);
                }
                if (enterprise != null) {
                    loginDTO.setNameNumber(enterprise.getId()+"");
                    //设置别名
                    loginDTO.setNickname(enterprise.getName());
                    //设置头像
                    loginDTO.setAvatar(enterprise.getImg());
                    //设置token
                    loginDTO.setToken(TokenUtils.genToken(loginDTO.getNameNumber(), loginDTO.getPassword()));
                    return Result.success(loginDTO);
                } else {
                    return Result.error(Constants.CODE_600);
                }
            case 3:
                //学生登录
                QueryWrapper<Student> studentQueryWrapper = new QueryWrapper<>();
                studentQueryWrapper
                        .and(i -> i
                                .eq("id", loginDTO.getNameNumber())
                                .or()
                                .eq("name", loginDTO.getNameNumber()))
                        .eq("password", loginDTO.getPassword());
                Student student;
                try {
                    student = studentMapper.selectOne(studentQueryWrapper);
                } catch (Exception e) {
                    return Result.error(Constants.CODE_500);
                }
                if (student != null) {
                    loginDTO.setNameNumber(student.getId()+"");
                    //设置别名
                    loginDTO.setNickname(student.getName());
                    //设置头像
                    loginDTO.setAvatar(student.getImg());
                    //设置token
                    loginDTO.setToken(TokenUtils.genToken(loginDTO.getNameNumber(), loginDTO.getPassword()));
                    return Result.success(loginDTO);
                } else {
                    return Result.error(Constants.CODE_600);
                }
            case 4:
                //管理员登录
                QueryWrapper<Admin> adminQueryWrapper = new QueryWrapper<>();
                adminQueryWrapper
                        .and(i -> i
                                .eq("id", loginDTO.getNameNumber())
                                .or()
                                .eq("name", loginDTO.getNameNumber()))
                        .eq("password", loginDTO.getPassword());
                Admin admin;
                try {
                    admin = adminMapper.selectOne(adminQueryWrapper);
                } catch (Exception e) {
                    return Result.error(Constants.CODE_500);
                }
                if (admin != null) {
                    //设置别名
                    loginDTO.setNickname(admin.getName());
                    //设置token
                    loginDTO.setToken(TokenUtils.genToken(loginDTO.getNameNumber(), loginDTO.getPassword()));
                    return Result.success(loginDTO);
                } else {
                    return Result.error(Constants.CODE_600);
                }
        }
        return Result.error(Constants.CODE_500);
    }

    @Override
    public String getPasswordById(String loginNumber, String longinType) {
        switch (longinType) {
            case "1":
                return schoolMapper.queryPasswordByUniversityCode(loginNumber);
            case "2":
                return enterpriseMapper.queryPasswordById(Long.parseLong(loginNumber));
            case "3":
                return studentMapper.queryPasswordById(Long.parseLong(loginNumber));
            case "4":
                return adminMapper.queryPasswordById(Long.parseLong(loginNumber));
        }
        return null;
    }


}
