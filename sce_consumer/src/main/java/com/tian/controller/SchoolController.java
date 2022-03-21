package com.tian.controller;

import com.tian.entity.PageResult;
import com.tian.entity.QueryPage;
import com.tian.entity.Result;
import com.tian.enums.MessageEnum;
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
    public boolean save(@RequestBody School school) {
        try {
            if (schoolService.inSchool(school.getUniversityCode())) {
                schoolService.update(school);
            } else {
                schoolService.insert(school);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
//            return new Result(false, MessageEnum.INSERT_SCHOOL_FAIL.getMessage());
        }
        return true;
//        return new Result(true, MessageEnum.INSERT_SCHOOL_SUCCESS.getMessage());
    }

    @RequestMapping("/delete")
    public boolean delete(String universityCode) {
        try {
            schoolService.delete(universityCode);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /*@RequestMapping("/update")
    public Result upDate(@RequestBody School school) {
        try {
            schoolService.update(school);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageEnum.UPDATE_SCHOOL_FAIL.getMessage());
        }
        return new Result(true, MessageEnum.UPDATE_SCHOOL_SUCCESS.getMessage());
    }*/

    @RequestMapping("/findAll")
    public Result findAll() {
        List<School> schools;
        try {
            schools = schoolService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            //查询失败
            return new Result(false, MessageEnum.QUERY_ALL_SCHOOL_FAIL.getMessage());
        }
        //查询成功
        return new Result(true, MessageEnum.QUERY_ALL_SCHOOL_SUCCESS.getMessage(), schools);
    }

    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPage queryPage) {
        return schoolService.findPage(queryPage);
    }

}
