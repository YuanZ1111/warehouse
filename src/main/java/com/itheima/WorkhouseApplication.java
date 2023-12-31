package com.itheima;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.CrossOrigin;

@MapperScan(basePackages = "com.itheima.mapper")
@SpringBootApplication
@EnableCaching  // 开启注解缓存
public class WorkhouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkhouseApplication.class, args);
    }

}
