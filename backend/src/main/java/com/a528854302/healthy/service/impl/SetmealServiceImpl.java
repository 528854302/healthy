package com.a528854302.healthy.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.a528854302.healthy.utils.PageUtils;
import com.a528854302.healthy.utils.R;
import com.a528854302.healthy.utils.Query;

import com.a528854302.healthy.dao.SetmealDao;
import com.a528854302.healthy.entity.SetmealEntity;
import com.a528854302.healthy.service.SetmealService;


@Service("setmealService")
public class SetmealServiceImpl extends ServiceImpl<SetmealDao, SetmealEntity> implements SetmealService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Object queryString = params.get("queryString");
        IPage<SetmealEntity> page = this.page(
                new Query<SetmealEntity>().getPage(params),
                queryString==null?new QueryWrapper<SetmealEntity>():
                        new QueryWrapper<SetmealEntity>().like("name",queryString)
        );
        return new PageUtils(page);
    }

}