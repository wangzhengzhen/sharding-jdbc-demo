package com.engrz.demo.sharding.jdbc.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.support.DefaultBeanNameGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@ComponentScan(basePackages = {"com.engrz.demo.sharding.jdbc.example"}, nameGenerator = DefaultBeanNameGenerator.class)
@MapperScan("com.engrz.demo.sharding.jdbc.example.mapper")
public class ExampleApplication {

    public static void main(String[] args) {

        SpringApplication.run(ExampleApplication.class);
    }
}
