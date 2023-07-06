package com.jinze.train.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.jinze.train.domain.member.Member;
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

    @Override
    public long register(String mobile) {

        Member member = memberMapper.findMemberByMobile(mobile);
        if (ObjectUtil.isNotNull(member)){
            throw new RuntimeException("手机号已被注册");
        }

        Member newMember = new Member();
        newMember.setId(System.currentTimeMillis());
        newMember.setMobile(mobile);

        long result = memberMapper.register(newMember);
        if (result <= 0 ){
            throw new RuntimeException("注册失败，请检查账号密码");
        }
        return newMember.getId();

    }
}
