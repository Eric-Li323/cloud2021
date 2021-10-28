package com.lyh.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lyh
 * @date 2021/10/28
 */
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        return "-------testA";
    }

    @GetMapping("/testB")
    public String testB(){
        return "-------testB";
    }
}
