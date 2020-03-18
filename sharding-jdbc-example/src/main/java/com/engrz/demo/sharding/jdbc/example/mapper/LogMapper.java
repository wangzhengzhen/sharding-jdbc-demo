package com.engrz.demo.sharding.jdbc.example.mapper;

import com.engrz.demo.sharding.jdbc.example.entity.TLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 系统日志表 Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-02-06
 */
public interface LogMapper extends BaseMapper<TLog> {

    @Select("select * from ds0.t_log")
    List<TLog> testQuery();

}
