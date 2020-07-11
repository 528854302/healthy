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
import com.a528854302.healthy.entity.SetmealCheckgroupEntity;
import com.a528854302.healthy.service.SetmealCheckgroupService;
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
@RequestMapping("/setmealcheckgroup")
public class SetmealCheckgroupController {
    @Autowired
    private SetmealCheckgroupService setmealCheckgroupService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestBody PageDto pageDto){
        HashMap params = new HashMap();
        params.put(Constant.PAGE,String.valueOf(pageDto.getCurrPage()));
        params.put(Constant.LIMIT,String.valueOf(pageDto.getPageSize()));
        params.put("queryString",pageDto.getQueryString());
        PageUtils page = setmealCheckgroupService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{setmealId}")
    public R info(@PathVariable("setmealId") Integer setmealId){
		SetmealCheckgroupEntity setmealCheckgroup = setmealCheckgroupService.getById(setmealId);
        return R.ok().put("data", setmealCheckgroup);
    }


    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SetmealCheckgroupEntity setmealCheckgroup){
		setmealCheckgroupService.save(setmealCheckgroup);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody SetmealCheckgroupEntity setmealCheckgroup){
		setmealCheckgroupService.updateById(setmealCheckgroup);
        return R.ok();
    }

    /**
     * 删除多个
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("healthy:setmealcheckgroup:delete")
    public R delete(@RequestBody Integer[] setmealIds){
		setmealCheckgroupService.removeByIds(Arrays.asList(setmealIds));
        return R.ok();
    }

    /**
     * 根据id删除
     */
    @RequestMapping("/delete/{id}")
    public R deleteById(@PathVariable Integer setmealId){
            setmealCheckgroupService.removeById(setmealId);
        return R.ok();
    }


}
