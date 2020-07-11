package com.a528854302.healthy.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.a528854302.healthy.utils.PageUtils;
import com.a528854302.healthy.utils.R;
import com.a528854302.healthy.utils.Query;

import com.a528854302.healthy.dao.UserDao;
import com.a528854302.healthy.entity.UserEntity;
import com.a528854302.healthy.service.UserService;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Object queryString = params.get("queryString");
        IPage<UserEntity> page = this.page(
                new Query<UserEntity>().getPage(params),
                queryString==null?new QueryWrapper<UserEntity>():
                        new QueryWrapper<UserEntity>().like("name",queryString)
        );
        return new PageUtils(page);
    }

}