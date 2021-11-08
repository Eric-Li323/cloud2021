package com.lyh.springcloud.service;

import com.lyh.springcloud.entities.CommonResult;
import com.lyh.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author lyh
 * @date 2021/11/8
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(44444,"服务降级返回，---PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}
