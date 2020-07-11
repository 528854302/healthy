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
@TableName("t_setmeal")
public class SetmealEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private String code;
	/**
	 * 
	 */
	private String helpcode;
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
	 * 
	 */
	private String remark;
	/**
	 * 
	 */
	private String attention;
	/**
	 * 
	 */
	private String img;

}
