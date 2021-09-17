package com.lyh.springcloud.config;

import feign.Logger;
import org.springframework.beans.factory.annotation.Configurable;

/**
 * OpenFeign日志增强
 * @author lyh
 * @date 2021/9/17
 */
@Configurable
public class FeignConfig {

    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
