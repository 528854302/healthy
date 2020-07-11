package com.a528854302.healthy.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.a528854302.healthy.utils.PageUtils;
import com.a528854302.healthy.utils.R;
import com.a528854302.healthy.utils.Query;

import com.a528854302.healthy.dao.OrderDao;
import com.a528854302.healthy.entity.OrderEntity;
import com.a528854302.healthy.service.OrderService;


@Service("orderService")
public class OrderServiceImpl extends ServiceImpl<OrderDao, OrderEntity> implements OrderService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Object queryString = params.get("queryString");
        IPage<OrderEntity> page = this.page(
                new Query<OrderEntity>().getPage(params),
                queryString==null?new QueryWrapper<OrderEntity>():
                        new QueryWrapper<OrderEntity>().like("name",queryString)
        );
        return new PageUtils(page);
    }

}