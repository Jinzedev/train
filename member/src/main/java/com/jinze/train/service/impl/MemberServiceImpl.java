package com.jinze.train.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.jinze.train.domain.member.Member;
import com.jinze.train.exception.BusinessException;
import com.jinze.train.exception.BusinessExceptionEnum;
import com.jinze.train.mapper.MemberMapper;
import com.jinze.train.service.MemberService;
import com.jinze.train.util.SnowUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *  Member信息实现类
 * @author jinze
 * @version 1.0
 */
@Service
@Slf4j
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
        newMember.setId(SnowUtil.getSnowflakeNextId());
        newMember.setMobile(mobile);

        long result = memberMapper.register(newMember);
        if (result <= 0 ){
            throw new BusinessException(BusinessExceptionEnum.MEMBER_REGISTER_FALSE);
        }
        return newMember.getId();

    }

    @Override
    public void sendCode(String mobile) {

        Member member = memberMapper.findMemberByMobile(mobile);

        if (ObjectUtil.isNull(member)){
            Member newMember = new Member();
            newMember.setId(SnowUtil.getSnowflakeNextId());
            newMember.setMobile(mobile);
            long result = memberMapper.register(newMember);
            if (result <= 0 ){
                throw new BusinessException(BusinessExceptionEnum.MEMBER_REGISTER_FALSE);
            }
        } else {
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_EXIST);
        }

        // 生成验证码
        // String code = RandomUtil.randomString(4);
        String code = "8888";
        log.info("生成短信验证码：{}", code);

        // 保存短信记录表：手机号，短信验证码，有效期，是否已使用，业务类型，发送时间，使用时间
        log.info("保存短信记录表");

        // 对接短信通道，发送短信
        log.info("对接短信通道");
    }
}
