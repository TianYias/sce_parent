package com.tian.service;

import com.tian.entity.PageResult;
import com.tian.entity.QueryPage;
import com.tian.pojo.Resume;

import java.util.List;

/**
* @author JJJJJ
* @description 针对表【t_resume】的数据库操作Service
* @createDate 2022-04-14 17:15:53
*/
public interface ResumeService {

    /**
     * 查询所有
     * @return
     */
    public List<Resume> findAll();

    /**
     * 分页查询
     * @param queryPage
     * @return
     */
    public PageResult findPage(QueryPage queryPage);

    /**
     * 判断是否存在
     * @param id
     * @return
     */
    public boolean inStudent(Long id);

    /**
     * 修改
     * @param resume
     */
    void update(Resume resume);

    /**
     * 删除
     * @param id
     */
    void delete(Long id);

    /**
     * 添加
     * @param resume
     */
    void insert(Resume resume);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Resume findOne(Long id);
}
