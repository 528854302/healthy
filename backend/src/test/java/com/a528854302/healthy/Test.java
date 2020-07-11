package com.a528854302.healthy;

import com.a528854302.healthy.service.CheckitemService;
import com.a528854302.healthy.utils.PageUtils;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

/**
 * @ClassName Test
 * @Description: TODO
 * @Author 528854302@qq.com
 * @Date 2020/7/11
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {
    @Autowired
    CheckitemService checkitemService;
    @org.junit.Test
    public void test(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("limit","5");
        map.put("page","1");
        PageUtils pageUtils = checkitemService.queryPage(map);
        System.out.println(pageUtils);
    }
}
