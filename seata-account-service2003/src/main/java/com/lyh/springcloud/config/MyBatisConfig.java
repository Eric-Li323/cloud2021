package com.lyh.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author lyh
 * @date 2021/11/15
 */
@Configuration
@MapperScan({"com.lyh.springcloud.dao"})
public class MyBatisConfig {
}
