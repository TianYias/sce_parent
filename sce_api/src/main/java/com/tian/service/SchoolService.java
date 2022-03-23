package com.tian.service;

import com.tian.entity.PageResult;
import com.tian.entity.QueryPage;
import com.tian.pojo.School;

import java.util.List;

/**
* @description 针对表【t_school】的数据库操作Service
*/
public interface SchoolService {
    /**
     * 查询所有
     * @return
     */
    public List<School> findAll();

    /**
     * 分页查询
     * @param queryPage
     * @return
     */
    public PageResult findPage(QueryPage queryPage);

    /**
     * 判断是否存在
     * @param universityCode
     * @return
     */
    public boolean inSchool(String universityCode);

    /**
     * 修改
     * @param school
     */
    void update(School school);

    /**
     * 删除
     * @param universityCode
     */
    void delete(String universityCode);

    /**
     * 添加
     * @param school
     */
    void insert(School school);

    /**
     * 登录验证
     * @param loginDTO
     * @return
     */
    /*Result login(LoginDTO loginDTO) throws ServiceException;*/
}
