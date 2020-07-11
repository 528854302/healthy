package com.a528854302.healthy.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.a528854302.healthy.utils.PageUtils;
import com.a528854302.healthy.utils.R;
import com.a528854302.healthy.utils.Query;

import com.a528854302.healthy.dao.CheckgroupCheckitemDao;
import com.a528854302.healthy.entity.CheckgroupCheckitemEntity;
import com.a528854302.healthy.service.CheckgroupCheckitemService;


@Service("checkgroupCheckitemService")
public class CheckgroupCheckitemServiceImpl extends ServiceImpl<CheckgroupCheckitemDao, CheckgroupCheckitemEntity> implements CheckgroupCheckitemService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Object queryString = params.get("queryString");
        IPage<CheckgroupCheckitemEntity> page = this.page(
                new Query<CheckgroupCheckitemEntity>().getPage(params),
                queryString==null?new QueryWrapper<CheckgroupCheckitemEntity>():
                        new QueryWrapper<CheckgroupCheckitemEntity>().like("name",queryString)
        );
        return new PageUtils(page);
    }

}