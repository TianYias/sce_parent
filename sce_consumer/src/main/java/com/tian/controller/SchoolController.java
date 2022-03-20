package com.tian.controller;

import com.tian.entity.Result;
import com.tian.enums.MessageEnum;
import com.tian.pojo.School;
import com.tian.service.SchoolService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("school")
public class SchoolController {

    @DubboReference
    private SchoolService schoolService;

    @RequestMapping("findAll")
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

}
