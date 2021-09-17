package com.lyh.springcloud.controller;

import com.lyh.springcloud.entities.CommonResult;
import com.lyh.springcloud.entities.Payment;
import com.lyh.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lyh
 * @date 2021/9/17
 */
@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
        //openfeign  的底层ribbon，客户端一般默认等待1秒钟就要拿到结果
        return paymentFeignService.paymentFeignTimeout();
    }
}
