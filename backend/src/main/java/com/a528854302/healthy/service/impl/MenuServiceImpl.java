package com.a528854302.healthy.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.a528854302.healthy.utils.PageUtils;
import com.a528854302.healthy.utils.R;
import com.a528854302.healthy.utils.Query;

import com.a528854302.healthy.dao.MenuDao;
import com.a528854302.healthy.entity.MenuEntity;
import com.a528854302.healthy.service.MenuService;


@Service("menuService")
public class MenuServiceImpl extends ServiceImpl<MenuDao, MenuEntity> implements MenuService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Object queryString = params.get("queryString");
        IPage<MenuEntity> page = this.page(
                new Query<MenuEntity>().getPage(params),
                queryString==null?new QueryWrapper<MenuEntity>():
                        new QueryWrapper<MenuEntity>().like("name",queryString)
        );
        return new PageUtils(page);
    }

}