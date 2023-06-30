package com.jinze.train.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * hello测试类
 * @author jinze
 * @version 1.0
 */
@RestController
@RequestMapping("member")
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
