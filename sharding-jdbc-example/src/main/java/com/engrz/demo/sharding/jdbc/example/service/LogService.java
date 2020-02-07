package com.engrz.demo.sharding.jdbc.example.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.engrz.demo.sharding.jdbc.example.entity.TLog;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 系统日志表 服务类
 * </p>
 *
 * @author jobob
 * @since 2020-02-06
 */
public interface LogService extends IService<TLog> {

    void add(TLog record);

    void modify(TLog record);

    void remove(TLog record);

    Page<TLog> query(Page<TLog> page, TLog record);

}
