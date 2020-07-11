package com.a528854302.healthy.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.a528854302.healthy.utils.PageUtils;
import com.a528854302.healthy.utils.R;
import com.a528854302.healthy.utils.Query;

import com.a528854302.healthy.dao.OrdersettingDao;
import com.a528854302.healthy.entity.OrdersettingEntity;
import com.a528854302.healthy.service.OrdersettingService;


@Service("ordersettingService")
public class OrdersettingServiceImpl extends ServiceImpl<OrdersettingDao, OrdersettingEntity> implements OrdersettingService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Object queryString = params.get("queryString");
        IPage<OrdersettingEntity> page = this.page(
                new Query<OrdersettingEntity>().getPage(params),
                queryString==null?new QueryWrapper<OrdersettingEntity>():
                        new QueryWrapper<OrdersettingEntity>().like("name",queryString)
        );
        return new PageUtils(page);
    }

}