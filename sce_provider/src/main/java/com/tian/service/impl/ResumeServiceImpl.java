package com.tian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tian.entity.Constants;
import com.tian.entity.PageResult;
import com.tian.entity.QueryPage;
import com.tian.mapper.ResumeMapper;
import com.tian.pojo.Resume;
import com.tian.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author JJJJJ
* @description 针对表【t_resume】的数据库操作Service实现
* @createDate 2022-04-14 17:15:53
*/
@Service
public class ResumeServiceImpl extends ServiceImpl<ResumeMapper, Resume>
    implements ResumeService{

    @Autowired
    private ResumeMapper resumeMapper;

    @Override
    public List<Resume> findAll() {
        return null;
    }

    @Override
    public PageResult findPage(QueryPage queryPage) {
        Page<Resume> resumePage = new Page<>(queryPage.getCurrentPage(), queryPage.getPageSize());
        QueryWrapper<Resume> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .like(queryPage.getQueryString() != null && queryPage.getQueryString() != "",
                        "name", queryPage.getQueryString())
                .or()
                .like(queryPage.getQueryString() != null && queryPage.getQueryString() != "",
                        "student_number", queryPage.getQueryString());
        resumeMapper.selectPage(resumePage, queryWrapper);
        return new PageResult(Constants.CODE_250.getCode(), resumePage.getTotal(), resumePage.getRecords());
    }

    @Override
    public boolean inStudent(Long id) {
        if (resumeMapper.isResume(id) != 0) {
            return true;
        }
        return false;
    }

    @Override
    public void update(Resume resume) {
        resumeMapper.updateById(resume);
    }

    @Override
    public void delete(Long id) {
        resumeMapper.deleteById(id);
    }

    @Override
    public void insert(Resume resume) {
        resumeMapper.insert(resume);
    }
}




