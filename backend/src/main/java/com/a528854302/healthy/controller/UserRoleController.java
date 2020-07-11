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
import com.a528854302.healthy.entity.UserRoleEntity;
import com.a528854302.healthy.service.UserRoleService;
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
@RequestMapping("/userrole")
public class UserRoleController {
    @Autowired
    private UserRoleService userRoleService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestBody PageDto pageDto){
        HashMap params = new HashMap();
        params.put(Constant.PAGE,String.valueOf(pageDto.getCurrPage()));
        params.put(Constant.LIMIT,String.valueOf(pageDto.getPageSize()));
        params.put("queryString",pageDto.getQueryString());
        PageUtils page = userRoleService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{userId}")
    public R info(@PathVariable("userId") Integer userId){
		UserRoleEntity userRole = userRoleService.getById(userId);
        return R.ok().put("data", userRole);
    }


    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody UserRoleEntity userRole){
		userRoleService.save(userRole);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody UserRoleEntity userRole){
		userRoleService.updateById(userRole);
        return R.ok();
    }

    /**
     * 删除多个
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("healthy:userrole:delete")
    public R delete(@RequestBody Integer[] userIds){
		userRoleService.removeByIds(Arrays.asList(userIds));
        return R.ok();
    }

    /**
     * 根据id删除
     */
    @RequestMapping("/delete/{id}")
    public R deleteById(@PathVariable Integer userId){
            userRoleService.removeById(userId);
        return R.ok();
    }


}
