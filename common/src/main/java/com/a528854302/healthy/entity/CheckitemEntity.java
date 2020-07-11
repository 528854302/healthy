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
 * @date 2020-07-11 10:45:22
 */
@Data
@TableName("t_checkitem")
public class CheckitemEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String code;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private String sex;
	/**
	 * 
	 */
	private String age;
	/**
	 * 
	 */
	private Float price;
	/**
	 * 查检项类型,分为检查和检验两种
	 */
	private String type;
	/**
	 * 
	 */
	private String attention;
	/**
	 * 
	 */
	private String remark;

}
