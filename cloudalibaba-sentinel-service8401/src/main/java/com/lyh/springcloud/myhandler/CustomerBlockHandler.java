package com.lyh.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lyh.springcloud.entities.CommonResult;
import com.lyh.springcloud.entities.Payment;

/**
 * @author lyh
 * @date 2021/11/4
 */

public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException exception){
        return new CommonResult(444,"按客户自定义,gloabl handlerException 全局处理-----1");
    }

    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(444,"按客户自定义,gloabl handlerException 全局处理-----2");
    }
}
