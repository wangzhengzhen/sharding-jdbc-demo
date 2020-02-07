package com.engrz.demo.sharding.jdbc.example.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.engrz.demo.sharding.jdbc.example.entity.TLog;
import com.engrz.demo.sharding.jdbc.example.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogService logService;

    @RequestMapping("/add")
    public String add(TLog record) {

        logService.add(record);
        return "success！";
    }

    @RequestMapping("/modify")
    public String modify(TLog record) {

        logService.modify(record);
        return "success！";
    }

    @RequestMapping("/remove")
    public String remove(TLog record) {

        logService.remove(record);
        return "success！";
    }

    @RequestMapping("/query")
    public Object query(Page<TLog> page, TLog record) {

        return logService.query(page, record);
    }

}
