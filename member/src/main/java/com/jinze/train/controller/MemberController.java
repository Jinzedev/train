package com.jinze.train.controller;

import com.jinze.train.service.MemberService;
import jakarta.annotation.Resource;
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
    public Integer count(){
        return memberService.count();
    }

    @PostMapping("/register")
    public long register(@RequestParam("mobile") String mobile){
        return memberService.register(mobile);
    }
}
