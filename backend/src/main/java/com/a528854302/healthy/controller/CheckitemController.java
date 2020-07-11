package com.a528854302.healthy.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.a528854302.healthy.dto.PageDto;
import com.a528854302.healthy.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.a528854302.healthy.entity.CheckitemEntity;
import com.a528854302.healthy.service.CheckitemService;
import com.a528854302.healthy.utils.PageUtils;
import com.a528854302.healthy.utils.R;



/**
 * 
 *
 * @author 528854302@qq.com
 * @email 528854302@qq.com
 * @date 2020-07-11 10:45:22
 */
@RestController
@RequestMapping("/checkitem")
public class CheckitemController {
    @Autowired
    private CheckitemService checkitemService;

    /**
     * 列表
     * 'page': this.pageIndex,
     * 'limit': this.pageSize,
     *  'key': this.dataForm.key
     */
    @RequestMapping("/list")
    //@RequiresPermissions("healthy:checkitem:list")
    public R list(@RequestBody PageDto pageDto){
        HashMap params = new HashMap();
        params.put(Constant.PAGE,String.valueOf(pageDto.getCurrPage()));
        params.put(Constant.LIMIT,String.valueOf(pageDto.getPageSize()));
        params.put("queryString",pageDto.getQueryString());
        PageUtils page = checkitemService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 根据id查询
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("healthy:checkitem:info")
    public R info(@PathVariable("id") Integer id){
		CheckitemEntity checkitem = checkitemService.getById(id);
        return R.ok().put("checkitem", checkitem);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("healthy:checkitem:save")
    public R save(@RequestBody CheckitemEntity checkitem){
		checkitemService.save(checkitem);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("healthy:checkitem:update")
    public R update(@RequestBody CheckitemEntity checkitem){
		checkitemService.updateById(checkitem);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("healthy:checkitem:delete")
    public R delete(@RequestBody Integer[] ids){
		checkitemService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete/{id}")
    public R deleteById(@PathVariable Integer id){
            checkitemService.removeById(id);
        return R.ok();
    }

}
