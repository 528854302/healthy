package com.a528854302.healthy.dto;

import lombok.Data;

/**
 * @ClassName PageDto
 * @Description: TODO
 * @Author 528854302@qq.com
 * @Date 2020/7/11
 **/
@Data
public class PageDto {
    private int currPage;
    private int pageSize;
    private String queryString;
}
