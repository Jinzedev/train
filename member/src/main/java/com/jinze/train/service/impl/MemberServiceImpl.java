package com.jinze.train.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.jinze.train.domain.member.Member;
import com.jinze.train.exception.BusinessException;
import com.jinze.train.exception.BusinessExceptionEnum;
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
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_EXIST);
        }

        Member newMember = new Member();
        newMember.setId(System.currentTimeMillis());
        newMember.setMobile(mobile);

        long result = memberMapper.register(newMember);
        if (result <= 0 ){
            throw new BusinessException(BusinessExceptionEnum.MEMBER_REGISTER_FALSE);
        }
        return newMember.getId();

    }
}
