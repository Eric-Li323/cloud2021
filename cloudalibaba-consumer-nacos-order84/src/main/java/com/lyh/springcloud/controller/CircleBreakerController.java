package com.lyh.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.lyh.springcloud.entities.CommonResult;
import com.lyh.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author lyh
 * @date 2021/11/5
 */
@RestController
@Slf4j
public class CircleBreakerController {

    public static final String SERVICE_URL="http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/fallback/{id}")
    @SentinelResource(value = "fallback") //没有配置
    public CommonResult<Payment> fallback(@PathVariable Long id){
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/"+id,CommonResult.class,id);

        if(id == 4){
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常。。。");
        } else if(result.getData() == null){
            throw  new NullPointerException("NullPointerException,该ID没有对应记录，空指针异常");
        }
        return result;
    }
}