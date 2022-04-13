package com.tian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tian.entity.Constants;
import com.tian.entity.PageResult;
import com.tian.entity.QueryPage;
import com.tian.mapper.StudentMapper;
import com.tian.pojo.Student;
import com.tian.service.StudentService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @description 针对表【t_student】的数据库操作Service实现
 */
@DubboService
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public PageResult findPage(QueryPage queryPage) {
        Page<Student> studentPage = new Page<>(queryPage.getCurrentPage(), queryPage.getPageSize());
        QueryWrapper<Student> studentQueryWrapper = new QueryWrapper<>();
        studentQueryWrapper
                .like(queryPage.getQueryString() != null && queryPage.getQueryString() != "",
                        "name", queryPage.getQueryString())
                .or()
                .like(queryPage.getQueryString() != null && queryPage.getQueryString() != "",
                        "student_number", queryPage.getQueryString());
        studentMapper.selectPage(studentPage, studentQueryWrapper);
        return new PageResult(Constants.CODE_250.getCode(), studentPage.getTotal(), studentPage.getRecords());
    }

    @Override
    public boolean inStudent(Long id) {
        if (studentMapper.isStudent(id) != 0) {
            return true;
        }
        return false;
    }

    @Override
    public void update(Student student) {
        studentMapper.updateById(student);
    }

    @Override
    public void delete(Long id) {
        studentMapper.deleteById(id);
    }

    @Override
    public void insert(Student student) {
        studentMapper.insert(student);
    }
}




