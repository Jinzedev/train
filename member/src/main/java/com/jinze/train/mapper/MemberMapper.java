package com.jinze.train.mapper;

import com.jinze.train.domain.Member;
import org.apache.ibatis.annotations.Mapper;

/**
 * Member表dao层
 * @author Jinze
 */
@Mapper
public interface MemberMapper {
    /***
     * 查询会员数量
     * @return int
     * @author jinze
     */
    int count();

    /***
     * 注册用户
     * @param member 用户信息
     * @return long
     * @author jinze
    */
    long register(Member member);


    /***
     * 根据手机号查询会员
     * @param mobile 手机号
     * @return java.lang.Boolean
     * @author jinze
    */
    Member findMemberByMobile(String mobile);
}
