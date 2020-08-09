package com.codemcd.springbootmybatisstart;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.codemcd.springbootmybatisstart")
public class SpringBootMybatisStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatisStartApplication.class, args);
    }

}
