package com.engrz.demo.sharding.jdbc.example.service.impl;

import com.engrz.demo.sharding.jdbc.example.entity.TLog;
import com.engrz.demo.sharding.jdbc.example.mapper.TLogMapper;
import com.engrz.demo.sharding.jdbc.example.service.LogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class LogServiceImpl extends ServiceImpl<TLogMapper, TLog> implements LogService {

}
