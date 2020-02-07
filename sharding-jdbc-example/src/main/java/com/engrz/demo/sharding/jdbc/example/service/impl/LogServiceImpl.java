package com.engrz.demo.sharding.jdbc.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.Update;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.engrz.demo.sharding.jdbc.example.entity.TLog;
import com.engrz.demo.sharding.jdbc.example.mapper.LogMapper;
import com.engrz.demo.sharding.jdbc.example.service.LogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统日志表 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-02-06
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, TLog> implements LogService {

    @Autowired
    private LogMapper logMapper;

    @Override
    public void add(TLog record) {

        super.save(record);
    }

    @Override
    public void modify(TLog record) {

        UpdateWrapper<TLog> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("log_level", record.getLogLevel());
        updateWrapper.set("log_title", record.getLogTitle());
        updateWrapper.set("log_content", record.getLogContent());
        updateWrapper.eq("log_id", record.getLogId());
        super.update(updateWrapper);
    }

    @Override
    public void remove(TLog record) {

        super.removeById(record.getLogId());
    }

    @Override
    public Page<TLog> query(Page<TLog> page, TLog record) {

        QueryWrapper<TLog> queryWrapper = new QueryWrapper<>();
        if (null != record.getLogId()) {
            queryWrapper.eq("log_id", record.getLogId());
        }
        if (null != record.getStartTime()) {
            queryWrapper.gt("create_time", record.getStartTime());
        }
        if (null != record.getEndTime()) {
            queryWrapper.lt("create_time", record.getEndTime());
        }

        return super.page(page, queryWrapper);
    }
}
