package com.a528854302.healthy.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author 528854302@qq.com
 * @email 528854302@qq.com
 * @date 2020-07-11 10:45:21
 */
@Data
@TableName("t_order")
public class OrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 员会id
	 */
	private Integer memberId;
	/**
	 * 约预日期
	 */
	private Date orderdate;
	/**
	 * 约预类型 电话预约/微信预约
	 */
	private String ordertype;
	/**
	 * 预约状态（是否到诊）
	 */
	private String orderstatus;
	/**
	 * 餐套id
	 */
	private Integer setmealId;

}
