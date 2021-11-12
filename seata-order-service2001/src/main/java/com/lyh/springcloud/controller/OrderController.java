package com.lyh.springcloud.controller;

import com.lyh.springcloud.domain.CommonResult;
import com.lyh.springcloud.domain.Order;
import com.lyh.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lyh
 * @date 2021/11/11
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}
