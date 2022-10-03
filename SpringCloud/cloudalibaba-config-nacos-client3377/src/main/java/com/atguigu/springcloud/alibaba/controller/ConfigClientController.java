package com.atguigu.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther zzyy
 * @create 2020-02-23 17:02
 */
@RestController
public class ConfigClientController {

    @Value("${user.name}")
    private String username;

    @Value("${user.age}")
    private String userage;

    @GetMapping("/config/info")
    public String getConfigInfo() {
        return username + ":" + userage;
    }
}
