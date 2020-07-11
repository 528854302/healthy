package com.a528854302.healthy.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.a528854302.healthy.utils.PageUtils;
import com.a528854302.healthy.utils.R;
import com.a528854302.healthy.utils.Query;

import com.a528854302.healthy.dao.SetmealCheckgroupDao;
import com.a528854302.healthy.entity.SetmealCheckgroupEntity;
import com.a528854302.healthy.service.SetmealCheckgroupService;


@Service("setmealCheckgroupService")
public class SetmealCheckgroupServiceImpl extends ServiceImpl<SetmealCheckgroupDao, SetmealCheckgroupEntity> implements SetmealCheckgroupService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Object queryString = params.get("queryString");
        IPage<SetmealCheckgroupEntity> page = this.page(
                new Query<SetmealCheckgroupEntity>().getPage(params),
                queryString==null?new QueryWrapper<SetmealCheckgroupEntity>():
                        new QueryWrapper<SetmealCheckgroupEntity>().like("name",queryString)
        );
        return new PageUtils(page);
    }

}