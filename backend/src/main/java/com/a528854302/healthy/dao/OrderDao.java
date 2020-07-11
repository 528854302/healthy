package com.a528854302.healthy.dao;

import com.a528854302.healthy.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author 528854302@qq.com
 * @email 528854302@qq.com
 * @date 2020-07-11 17:48:09
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
