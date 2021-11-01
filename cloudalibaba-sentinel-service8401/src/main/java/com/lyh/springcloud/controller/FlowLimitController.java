package com.lyh.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author lyh
 * @date 2021/10/28
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        /*//暂停毫秒
        try{
            TimeUnit.MILLISECONDS.sleep(8000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }*/
        return "-------testA";
    }

    @GetMapping("/testB")
    public String testB(){
        log.info(Thread.currentThread().getName()+"\t"+"...testB");
        return "-------testB";
    }

    @GetMapping("/testD")
    public String testD(){
        /*//暂停 秒
        try{
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        log.info("testD 测试RT");*/
        log.info("testD 异常比例");
        int age = 10/0;
        return "-------testD";
    }

    @GetMapping("/testE")
    public String testE(){
        log.info("testE 异常数");
        int age = 10/0;
        return "-------testE  测试异常数";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){
        int age = 10/0;
        return "-------testHotKey  正常访问";
    }

    public String deal_testHotKey(String p1, String p2, BlockException exception){

        return "-------deal_testHotKey,访问失败/(ㄒoㄒ)/~~"; //sentinel系统默认提示：Blocked by Sentinel (flow limiting)
    }
}
