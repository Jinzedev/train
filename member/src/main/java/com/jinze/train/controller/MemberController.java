package com.jinze.train.controller;

import com.jinze.train.domain.member.req.MemberRegisterReq;
import com.jinze.train.domain.member.req.MemberSendCodeReq;
import com.jinze.train.resp.CommonResp;
import com.jinze.train.service.MemberService;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Member前端控制器
 *
 * @author jinze
 * @version 1.0
 */
@RestController
@RequestMapping("/member")
public class MemberController {
    @Resource
    private MemberService memberService;

    @GetMapping("/count")
    public CommonResp<Integer> count(){
        int count = memberService.count();
        return new CommonResp<>(count);
    }

    @PostMapping("/register")
    public CommonResp<Long> register(@Validated MemberRegisterReq registerReq){
        long userId = memberService.register(registerReq.getMobile());
        return new CommonResp<>(userId);
    }


    @PostMapping("/sendCode")
    public CommonResp<Long> sendCode(@Validated MemberSendCodeReq sendCodeReq){
        memberService.sendCode(sendCodeReq.getMobile());
        System.out.print("ddd");
        return new CommonResp<>();
    }
}
