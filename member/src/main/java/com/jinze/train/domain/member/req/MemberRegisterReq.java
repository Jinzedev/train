package com.jinze.train.domain.member.req;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * 用户注册请求体
 * @author jinze
 * @version 1.0
 */
@Data
public class MemberRegisterReq {

    @NotBlank(message = "手机号不能为空")
    private String mobile;



}
