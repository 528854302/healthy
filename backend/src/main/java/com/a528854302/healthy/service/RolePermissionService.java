package com.a528854302.healthy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.a528854302.healthy.utils.PageUtils;
import com.a528854302.healthy.entity.RolePermissionEntity;

import java.util.Map;

/**
 * 
 *
 * @author 528854302@qq.com
 * @email 528854302@qq.com
 * @date 2020-07-11 10:45:21
 */
public interface RolePermissionService extends IService<RolePermissionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

