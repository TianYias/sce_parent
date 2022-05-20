package com.tian.service;

import com.tian.entity.PageResult;
import com.tian.entity.QueryPage;
import com.tian.pojo.Student;

import java.util.List;

/**
* @description 针对表【t_student】的数据库操作Service
*/
public interface StudentService {

    /**
     * 查询所有
     * @return
     */
    public List<Student> findAll();

    /**
     * 分页查询
     * @param queryPage
     * @return
     */
    public PageResult findPage(QueryPage queryPage);
    public PageResult findPage1(QueryPage queryPage);

    /**
     * 判断是否存在
     * @param id
     * @return
     */
    public boolean inStudent(Long id);

    /**
     * 修改
     * @param student
     */
    void update(Student student);

    /**
     * 删除
     * @param id
     */
    void delete(Long id);

    /**
     * 添加
     * @param student
     */
    void insert(Student student);

}
