package com.tian.controller;

import com.tian.entity.PageResult;
import com.tian.entity.QueryPage;
import com.tian.entity.Result;
import com.tian.pojo.Student;
import com.tian.service.StudentService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @DubboReference
    private StudentService studentService;

    @RequestMapping("/save")
    public Result save(@RequestBody Student student) {
        try {
            if (studentService.inStudent(student.getId())) {
                studentService.update(student);
            } else {
                studentService.insert(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error();
        }
        return Result.success();
    }

    @RequestMapping("/delete")
    public Result delete(Long id) {
        try {
            studentService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error();
        }
        return Result.success();
    }

    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPage queryPage) {
        return studentService.findPage(queryPage);
    }
}
