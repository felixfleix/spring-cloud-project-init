package com.felix.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"com.felix.mapper"})
public class MybatisConfiguration {



}
