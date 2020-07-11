package com.a528854302.healthy.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.a528854302.healthy.utils.PageUtils;
import com.a528854302.healthy.utils.R;
import com.a528854302.healthy.utils.Query;

import com.a528854302.healthy.dao.RoleDao;
import com.a528854302.healthy.entity.RoleEntity;
import com.a528854302.healthy.service.RoleService;


@Service("roleService")
public class RoleServiceImpl extends ServiceImpl<RoleDao, RoleEntity> implements RoleService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Object queryString = params.get("queryString");
        IPage<RoleEntity> page = this.page(
                new Query<RoleEntity>().getPage(params),
                queryString==null?new QueryWrapper<RoleEntity>():
                        new QueryWrapper<RoleEntity>().like("name",queryString)
        );
        return new PageUtils(page);
    }

}