package com.jinze.train.controller;

import com.jinze.train.domain.member.req.MemberLoginReq;
import com.jinze.train.domain.member.req.MemberRegisterReq;
import com.jinze.train.domain.member.req.MemberSendCodeReq;
import com.jinze.train.domain.member.resp.MemberLoginResp;
import com.jinze.train.resp.CommonResp;
import com.jinze.train.service.MemberService;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public CommonResp<Long> sendCode(@Validated @RequestBody MemberSendCodeReq sendCodeReq){
        memberService.sendCode(sendCodeReq.getMobile());
        System.out.print("ddd");
        return new CommonResp<>();
    }

    @PostMapping("/login")
    public CommonResp<MemberLoginResp> login(@Validated MemberLoginReq loginReq){
        MemberLoginResp loginResp = memberService.login(loginReq.getMobile(), loginReq.getCode());
        return new CommonResp<>(loginResp);
    }
}
