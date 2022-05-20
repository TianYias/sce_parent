package com.tian.service;

import com.tian.entity.PageResult;
import com.tian.entity.QueryPage;
import com.tian.pojo.Enterprise;

import java.util.List;

/**
* @description 针对表【t_enterprise】的数据库操作Service
*/
public interface EnterpriseService {

    /**
     * 查询所有
     * @return
     */
    public List<Enterprise> findAll();

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
    public boolean inEnterprise(Long id);

    /**
     * 判断是否存在
     * @param phone
     * @return
     */
    //public boolean inEnterprise(String phone);

    /**
     * 修改
     * @param enterprise
     */
    void update(Enterprise enterprise);

    /**
     * 删除
     * @param id
     */
    void delete(Long id);

    /**
     * 添加
     * @param enterprise
     */
    void insert(Enterprise enterprise);
}
