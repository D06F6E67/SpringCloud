package com.lee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/a")
    public String a(String s) {
        System.out.println(s);
        return new RestTemplate().getForObject("http://localhost:8710/hello?s=" + s, String.class);
    }

    @GetMapping("/b")
    public String b(String s) {
        System.out.println(s);
        ServiceInstance service =  loadBalancerClient.choose("service");
        String host = service.getHost();
        Integer port = service.getPort();
        String url = "http://" + host + ":" + port;
        System.out.println(url);
        return  new RestTemplate().getForObject(url + "/hello?s=" + s, String.class);
    }

    @GetMapping("/c")
    public String c(String s) {
        System.out.println(s);
        return restTemplate.getForObject("http://SERVICE/hello?s=" + s, String.class);
    }

}
