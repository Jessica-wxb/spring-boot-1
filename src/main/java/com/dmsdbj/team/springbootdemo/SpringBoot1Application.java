package com.dmsdbj.team.springbootdemo;

import com.google.common.annotations.VisibleForTesting;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;


@SpringBootApplication
// 配置MapperScan注解去扫描Mapper文件夹
@MapperScan(basePackages = "com.dmsdbj.team.springbootdemo.mapper")

public class SpringBoot1Application {

    public static void main( String[] args) {

        SpringApplication.run(SpringBoot1Application.class, args);
    }

    /**
     * SQL执行效率插件
     */
   /* @Bean
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }*/



}
