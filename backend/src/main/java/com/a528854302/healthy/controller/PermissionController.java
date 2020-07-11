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
import com.a528854302.healthy.entity.PermissionEntity;
import com.a528854302.healthy.service.PermissionService;
import com.a528854302.healthy.utils.PageUtils;
import com.a528854302.healthy.utils.R;
import com.a528854302.healthy.dto.PageDto;
import com.a528854302.healthy.utils.Constant;



/**
 * 权限
 *
 * @author 528854302@qq.com
 * @email 528854302@qq.com
 * @date 2020-07-11 17:48:09
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestBody PageDto pageDto){
        HashMap params = new HashMap();
        params.put(Constant.PAGE,String.valueOf(pageDto.getCurrPage()));
        params.put(Constant.LIMIT,String.valueOf(pageDto.getPageSize()));
        params.put("queryString",pageDto.getQueryString());
        PageUtils page = permissionService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		PermissionEntity permission = permissionService.getById(id);
        return R.ok().put("data", permission);
    }


    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PermissionEntity permission){
		permissionService.save(permission);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody PermissionEntity permission){
		permissionService.updateById(permission);
        return R.ok();
    }

    /**
     * 删除多个
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("healthy:permission:delete")
    public R delete(@RequestBody Integer[] ids){
		permissionService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 根据id删除
     */
    @RequestMapping("/delete/{id}")
    public R deleteById(@PathVariable Integer id){
            permissionService.removeById(id);
        return R.ok();
    }


}
