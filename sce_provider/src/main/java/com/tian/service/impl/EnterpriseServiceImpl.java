package com.tian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tian.entity.Constants;
import com.tian.entity.PageResult;
import com.tian.entity.QueryPage;
import com.tian.mapper.EnterpriseMapper;
import com.tian.pojo.Enterprise;
import com.tian.service.EnterpriseService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author JJJJJ
 * @description 针对表【t_enterprise】的数据库操作Service实现
 * @createDate 2022-04-03 14:27:18
 */
@DubboService
public class EnterpriseServiceImpl extends ServiceImpl<EnterpriseMapper, Enterprise>
        implements EnterpriseService {

    @Autowired
    private EnterpriseMapper enterpriseMapper;

    @Override
    public List<Enterprise> findAll() {
        return null;
    }

    @Override
    public PageResult findPage(QueryPage queryPage) {
        Page<Enterprise> enterprisePage = new Page<>(queryPage.getCurrentPage(), queryPage.getPageSize());
        QueryWrapper<Enterprise> enterpriseQueryWrapper = new QueryWrapper<>();
        enterpriseQueryWrapper
                .like(queryPage.getQueryString() != null && queryPage.getQueryString() != "",
                        "name", queryPage.getQueryString())
                .or()
                .like(queryPage.getQueryString() != null && queryPage.getQueryString() != "",
                        "business_code", queryPage.getQueryString());
        enterpriseMapper.selectPage(enterprisePage, enterpriseQueryWrapper);
        return new PageResult(Constants.CODE_250.getCode(), enterprisePage.getTotal(), enterprisePage.getRecords());
    }

    @Override
    public boolean inEnterprise(Long id) {
        if (enterpriseMapper.isEnterprise(id) != 0) {
            return true;
        }
        return false;
    }

    @Override
    public void update(Enterprise enterprise) {
        enterpriseMapper.updateById(enterprise);
    }

    @Override
    public void delete(Long id) {
        enterpriseMapper.deleteById(id);
    }

    @Override
    public void insert(Enterprise enterprise) {
        enterpriseMapper.insert(enterprise);
    }
}




