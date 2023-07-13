package com.jinze.train.service;

import com.jinze.train.domain.member.resp.MemberLoginResp;

/***
 * 会员表 服务
 * @author jinze
*/
public interface MemberService {

    /***
     * 查询数量
     * @return int
     * @author jinze
    */
    int count();

    /***
     * 根据手机号注册用户
     * @param mobile 手机号
     * @return long
     * @author jinze
    */
    long register(String mobile);

    /***
     * 发送短信接口
     * @param mobile 手机号
     * @author jinze
    */
    void sendCode(String mobile);

    /***
     * 登录
     * @param mobile 手机号
     * @param code 验证码
     * @author jinze
     */
    MemberLoginResp login(String mobile, String code);
}
