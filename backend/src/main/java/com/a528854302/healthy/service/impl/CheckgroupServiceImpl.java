package com.a528854302.healthy.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.a528854302.healthy.utils.PageUtils;
import com.a528854302.healthy.utils.R;
import com.a528854302.healthy.utils.Query;

import com.a528854302.healthy.dao.CheckgroupDao;
import com.a528854302.healthy.entity.CheckgroupEntity;
import com.a528854302.healthy.service.CheckgroupService;


@Service("checkgroupService")
public class CheckgroupServiceImpl extends ServiceImpl<CheckgroupDao, CheckgroupEntity> implements CheckgroupService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Object queryString = params.get("queryString");
        IPage<CheckgroupEntity> page = this.page(
                new Query<CheckgroupEntity>().getPage(params),
                queryString==null?new QueryWrapper<CheckgroupEntity>():
                        new QueryWrapper<CheckgroupEntity>().like("name",queryString)
        );
        return new PageUtils(page);
    }

}