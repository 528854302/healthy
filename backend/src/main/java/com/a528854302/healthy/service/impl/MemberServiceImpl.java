package com.a528854302.healthy.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.a528854302.healthy.utils.PageUtils;
import com.a528854302.healthy.utils.R;
import com.a528854302.healthy.utils.Query;

import com.a528854302.healthy.dao.MemberDao;
import com.a528854302.healthy.entity.MemberEntity;
import com.a528854302.healthy.service.MemberService;


@Service("memberService")
public class MemberServiceImpl extends ServiceImpl<MemberDao, MemberEntity> implements MemberService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Object queryString = params.get("queryString");
        IPage<MemberEntity> page = this.page(
                new Query<MemberEntity>().getPage(params),
                queryString==null?new QueryWrapper<MemberEntity>():
                        new QueryWrapper<MemberEntity>().like("name",queryString)
        );
        return new PageUtils(page);
    }

}