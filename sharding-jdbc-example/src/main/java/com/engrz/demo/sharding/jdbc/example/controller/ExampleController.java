package com.engrz.demo.sharding.jdbc.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example")
public class ExampleController {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    /**
     * 生成测试数据
     * @return
     */
    @RequestMapping("/genTestData")
    public String genTestData() {

        logger.info("开始生成测试数据");

        return "finish！";
    }

}
