package com.lyh.springcloud.service.impl;

import com.lyh.springcloud.dao.PaymentDao;
import com.lyh.springcloud.entities.Payment;
import com.lyh.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

//    @Autowired  两种注解均可
    @Resource
    private PaymentDao paymentDao;

    //写操作
    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    //读操作
    public Payment getPaymentById(@Param("id") Long id){
        return paymentDao.getPaymentById(id);
    }
}
