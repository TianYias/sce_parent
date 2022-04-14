package com.tian.controller;

import com.tian.entity.Result;
import com.tian.pojo.Resume;
import com.tian.service.ResumeService;
import org.apache.dubbo.config.annotation.DubboReference;
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
}
