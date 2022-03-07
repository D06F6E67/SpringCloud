package com.lee.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "nacos-server")
public interface TestFeignClient {

    @GetMapping("/name")
    String name();
}
