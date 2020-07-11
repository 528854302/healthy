package com.a528854302.healthy.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.a528854302.healthy.entity.RolePermissionEntity;
import com.a528854302.healthy.service.RolePermissionService;
import com.a528854302.healthy.utils.PageUtils;
import com.a528854302.healthy.utils.R;
import com.a528854302.healthy.dto.PageDto;
import com.a528854302.healthy.utils.Constant;



/**
 * 
 *
 * @author 528854302@qq.com
 * @email 528854302@qq.com
 * @date 2020-07-11 17:48:09
 */
@RestController
@RequestMapping("/rolepermission")
public class RolePermissionController {
    @Autowired
    private RolePermissionService rolePermissionService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestBody PageDto pageDto){
        HashMap params = new HashMap();
        params.put(Constant.PAGE,String.valueOf(pageDto.getCurrPage()));
        params.put(Constant.LIMIT,String.valueOf(pageDto.getPageSize()));
        params.put("queryString",pageDto.getQueryString());
        PageUtils page = rolePermissionService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{roleId}")
    public R info(@PathVariable("roleId") Integer roleId){
		RolePermissionEntity rolePermission = rolePermissionService.getById(roleId);
        return R.ok().put("data", rolePermission);
    }


    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody RolePermissionEntity rolePermission){
		rolePermissionService.save(rolePermission);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody RolePermissionEntity rolePermission){
		rolePermissionService.updateById(rolePermission);
        return R.ok();
    }

    /**
     * 删除多个
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("healthy:rolepermission:delete")
    public R delete(@RequestBody Integer[] roleIds){
		rolePermissionService.removeByIds(Arrays.asList(roleIds));
        return R.ok();
    }

    /**
     * 根据id删除
     */
    @RequestMapping("/delete/{id}")
    public R deleteById(@PathVariable Integer roleId){
            rolePermissionService.removeById(roleId);
        return R.ok();
    }


}
