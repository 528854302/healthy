package com.a528854302.healthy.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.a528854302.healthy.utils.PageUtils;
import com.a528854302.healthy.utils.R;
import com.a528854302.healthy.utils.Query;

import com.a528854302.healthy.dao.PermissionDao;
import com.a528854302.healthy.entity.PermissionEntity;
import com.a528854302.healthy.service.PermissionService;


@Service("permissionService")
public class PermissionServiceImpl extends ServiceImpl<PermissionDao, PermissionEntity> implements PermissionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Object queryString = params.get("queryString");
        IPage<PermissionEntity> page = this.page(
                new Query<PermissionEntity>().getPage(params),
                queryString==null?new QueryWrapper<PermissionEntity>():
                        new QueryWrapper<PermissionEntity>().like("name",queryString)
        );
        return new PageUtils(page);
    }

}