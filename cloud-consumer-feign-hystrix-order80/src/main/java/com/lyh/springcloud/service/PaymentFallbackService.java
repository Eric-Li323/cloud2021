package com.lyh.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * 服务器端宕机后调用自身的处理方法
 * @author lyh
 * @date 2021/9/22
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----PaymentFallbackService  **paymentInfo_OK**  fall back, /(ㄒoㄒ)/~~";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----PaymentFallbackService  **paymentInfo_TimeOut** fall back, /(ㄒoㄒ)/~~";
    }
}
