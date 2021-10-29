package com.lyh.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author lyh
 * @date 2021/10/28
 */
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        //暂停毫秒
        try{
            TimeUnit.MILLISECONDS.sleep(8000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "-------testA";
    }

    @GetMapping("/testB")
    public String testB(){
        return "-------testB";
    }
}
