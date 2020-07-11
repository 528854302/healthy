package com.a528854302.healthy.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.a528854302.healthy.utils.PageUtils;
import com.a528854302.healthy.utils.R;
import com.a528854302.healthy.utils.Query;

import com.a528854302.healthy.dao.CheckitemDao;
import com.a528854302.healthy.entity.CheckitemEntity;
import com.a528854302.healthy.service.CheckitemService;


@Service("checkitemService")
public class CheckitemServiceImpl extends ServiceImpl<CheckitemDao, CheckitemEntity> implements CheckitemService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Object queryString = params.get("queryString");
        IPage<CheckitemEntity> page = this.page(
                new Query<CheckitemEntity>().getPage(params),
                queryString==null?new QueryWrapper<CheckitemEntity>():
                        new QueryWrapper<CheckitemEntity>().like("name",queryString)
        );
        return new PageUtils(page);
    }

}