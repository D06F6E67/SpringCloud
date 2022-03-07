package com.lee.controller;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.SQLOutput;

@RestController
public class TestController {

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/test")
    public String test() {
        String server = "Server: " + discoveryClient.getServices().get(0);
        System.out.println(server);
        return server;
    }

    @GetMapping("/hello")
    public String hello(String s) {
        System.out.println("Hello:" +s);
        return "Hello " + s;
    }
}
