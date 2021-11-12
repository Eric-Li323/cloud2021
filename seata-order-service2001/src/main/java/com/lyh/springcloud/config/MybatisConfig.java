package com.lyh.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.lyh.springcloud.dao"})
public class MybatisConfig {
}
