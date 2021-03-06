package com.tian.controller;

import com.tian.entity.PageResult;
import com.tian.entity.QueryPage;
import com.tian.entity.Result;
import com.tian.pojo.Resume;
import com.tian.service.ResumeService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resume")
public class ResumeController {

    @DubboReference
    private ResumeService resumeService;

    @RequestMapping("/save")
    public Result save(@RequestBody Resume resume) {
        try {
            if (resumeService.inStudent(resume.getId())) {
                resumeService.update(resume);
            } else {
                resumeService.insert(resume);
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
            resumeService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error();
        }
        return Result.success();
    }

    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPage queryPage) {
        return resumeService.findPage(queryPage);
    }

    @RequestMapping("/{id}")
    public Result findOne(@PathVariable Long id) {
        Resume resume;
        try {
            resume = resumeService.findOne(id);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error();
        }
        return Result.success(resume);
    }
}
