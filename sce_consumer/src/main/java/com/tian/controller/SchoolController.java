package com.tian.controller;

import com.tian.entity.PageResult;
import com.tian.entity.QueryPage;
import com.tian.entity.Result;
import com.tian.pojo.School;
import com.tian.service.SchoolService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/school")
public class SchoolController {

    @DubboReference
    private SchoolService schoolService;

    @RequestMapping("/save")
    public Result save(@RequestBody School school) {
        try {
            if (schoolService.inSchool(school.getUniversityCode())) {
                schoolService.update(school);
            } else {
                schoolService.insert(school);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error();
        }
        return Result.success();
    }

    @RequestMapping("/delete")
    public Result delete(String universityCode) {
        try {
            schoolService.delete(universityCode);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error();
        }
        return Result.success();
    }

    @RequestMapping("/findAll")
    public Result findAll() {
        List<School> schools;
        try {
            schools = schoolService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            //查询失败
            return Result.error();
        }
        //查询成功
        return Result.success(schools);
    }

    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPage queryPage) {
        return schoolService.findPage(queryPage);
    }

}
