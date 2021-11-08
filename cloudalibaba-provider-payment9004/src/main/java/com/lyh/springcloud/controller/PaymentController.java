package com.lyh.springcloud.controller;

import com.lyh.springcloud.entities.CommonResult;
import com.lyh.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author lyh
 * @date 2021/11/4
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap = new HashMap<>();

    static {
        hashMap.put(1L,new Payment(1L,"fghkgjhjgjhkgkhjghgghgdtru"));
        hashMap.put(2L,new Payment(2L,"iuyophughjkhjgydtyiytyyghg"));
        hashMap.put(3L,new Payment(3L,"youigkbhftuftycfgfgyiguhgh"));
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id")Long id){
        Payment payment = hashMap.get(id);
        CommonResult<Payment> result = new CommonResult(200,"from mysql,serverPort: "+serverPort,payment);
        return result;
    }
}
