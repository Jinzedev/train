package com.jinze.train.exception;



/**
 * 业务异常枚举
 * @author jinze
*/
public enum BusinessExceptionEnum {
    MEMBER_MOBILE_EXIST("手机号已注册"),
    MEMBER_MOBILE_NOT_EXIST("手机号未注册"),
    MEMBER_MOBILE_CODE_ERROR("验证码出错"),
    MEMBER_REGISTER_FALSE("注册失败，请重试");

    private String desc;

    BusinessExceptionEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
