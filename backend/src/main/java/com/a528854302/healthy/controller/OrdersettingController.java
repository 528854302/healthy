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
import com.a528854302.healthy.entity.OrdersettingEntity;
import com.a528854302.healthy.service.OrdersettingService;
import com.a528854302.healthy.utils.PageUtils;
import com.a528854302.healthy.utils.R;
import com.a528854302.healthy.dto.PageDto;
import com.a528854302.healthy.utils.Constant;



/**
 * 订单设置
 *
 * @author 528854302@qq.com
 * @email 528854302@qq.com
 * @date 2020-07-11 17:48:09
 */
@RestController
@RequestMapping("/ordersetting")
public class OrdersettingController {
    @Autowired
    private OrdersettingService ordersettingService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestBody PageDto pageDto){
        HashMap params = new HashMap();
        params.put(Constant.PAGE,String.valueOf(pageDto.getCurrPage()));
        params.put(Constant.LIMIT,String.valueOf(pageDto.getPageSize()));
        params.put("queryString",pageDto.getQueryString());
        PageUtils page = ordersettingService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		OrdersettingEntity ordersetting = ordersettingService.getById(id);
        return R.ok().put("data", ordersetting);
    }


    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody OrdersettingEntity ordersetting){
		ordersettingService.save(ordersetting);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody OrdersettingEntity ordersetting){
		ordersettingService.updateById(ordersetting);
        return R.ok();
    }

    /**
     * 删除多个
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("healthy:ordersetting:delete")
    public R delete(@RequestBody Integer[] ids){
		ordersettingService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 根据id删除
     */
    @RequestMapping("/delete/{id}")
    public R deleteById(@PathVariable Integer id){
            ordersettingService.removeById(id);
        return R.ok();
    }


}
