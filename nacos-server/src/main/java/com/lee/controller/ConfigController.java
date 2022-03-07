package com.lee.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope  // 动态刷新
@RestController
public class ConfigController {

    @Value("${name: a}")
    private String name;

    @GetMapping("/name")
    public String name() {
        System.out.println(name);
        return  name;
    }
}
