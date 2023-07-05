package com.jinze.train.controller;

import com.jinze.train.service.MemberService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
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
    public Integer count(){
        return memberService.count();
    }


}
