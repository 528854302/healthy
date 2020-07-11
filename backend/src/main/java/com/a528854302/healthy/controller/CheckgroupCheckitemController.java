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
import com.a528854302.healthy.entity.CheckgroupCheckitemEntity;
import com.a528854302.healthy.service.CheckgroupCheckitemService;
import com.a528854302.healthy.utils.PageUtils;
import com.a528854302.healthy.utils.R;
import com.a528854302.healthy.dto.PageDto;
import com.a528854302.healthy.utils.Constant;



/**
 * 检查组检查项关联
 *
 * @author 528854302@qq.com
 * @email 528854302@qq.com
 * @date 2020-07-11 17:48:09
 */
@RestController
@RequestMapping("/checkgroupcheckitem")
public class CheckgroupCheckitemController {
    @Autowired
    private CheckgroupCheckitemService checkgroupCheckitemService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestBody PageDto pageDto){
        HashMap params = new HashMap();
        params.put(Constant.PAGE,String.valueOf(pageDto.getCurrPage()));
        params.put(Constant.LIMIT,String.valueOf(pageDto.getPageSize()));
        params.put("queryString",pageDto.getQueryString());
        PageUtils page = checkgroupCheckitemService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{checkgroupId}")
    public R info(@PathVariable("checkgroupId") Integer checkgroupId){
		CheckgroupCheckitemEntity checkgroupCheckitem = checkgroupCheckitemService.getById(checkgroupId);
        return R.ok().put("data", checkgroupCheckitem);
    }


    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CheckgroupCheckitemEntity checkgroupCheckitem){
		checkgroupCheckitemService.save(checkgroupCheckitem);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CheckgroupCheckitemEntity checkgroupCheckitem){
		checkgroupCheckitemService.updateById(checkgroupCheckitem);
        return R.ok();
    }

    /**
     * 删除多个
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("healthy:checkgroupcheckitem:delete")
    public R delete(@RequestBody Integer[] checkgroupIds){
		checkgroupCheckitemService.removeByIds(Arrays.asList(checkgroupIds));
        return R.ok();
    }

    /**
     * 根据id删除
     */
    @RequestMapping("/delete/{id}")
    public R deleteById(@PathVariable Integer checkgroupId){
            checkgroupCheckitemService.removeById(checkgroupId);
        return R.ok();
    }


}
