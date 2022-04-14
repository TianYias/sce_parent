package com.tian.controller;

import com.tian.entity.PageResult;
import com.tian.entity.QueryPage;
import com.tian.entity.Result;
import com.tian.pojo.Enterprise;
import com.tian.service.EnterpriseService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enterprise")
public class EnterpriseController {

    @DubboReference
    private EnterpriseService enterpriseService;

    @RequestMapping("/save")
    public Result save(@RequestBody Enterprise enterprise) {
        try {
            if (enterpriseService.inEnterprise(enterprise.getId())) {
                enterpriseService.update(enterprise);
            } else {
                enterpriseService.insert(enterprise);
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
            enterpriseService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error();
        }
        return Result.success();
    }

    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPage queryPage) {
        return enterpriseService.findPage(queryPage);
    }
}
