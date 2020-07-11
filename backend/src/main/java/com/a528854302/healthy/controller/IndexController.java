package com.a528854302.healthy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName IndexController
 * @Description: TODO
 * @Author 528854302@qq.com
 * @Date 2020/7/11
 **/
@Controller
public class IndexController {

    @RequestMapping("/{pageName}")
    public ModelAndView getPage(@PathVariable String pageName, ModelAndView modelAndView){
        modelAndView.setViewName(pageName);
        return modelAndView;
    }
}
