package com.jinze.train.service.impl;

import com.jinze.train.mapper.MemberMapper;
import com.jinze.train.service.MemberService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *  Member信息实现类
 * @author jinze
 * @version 1.0
 */
@Service
public class MemberServiceImpl implements MemberService {
    @Resource
    private MemberMapper memberMapper;

    @Override
    public int count() {
        return memberMapper.count();
    }
}
