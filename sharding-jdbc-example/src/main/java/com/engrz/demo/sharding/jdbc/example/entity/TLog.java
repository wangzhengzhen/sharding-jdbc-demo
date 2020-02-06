package com.engrz.demo.sharding.jdbc.example.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统日志表
 * </p>
 *
 * @author jobob
 * @since 2020-02-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 日志id
     */
    private Long logId;

    /**
     * 级别
     */
    private Integer logLevel;

    /**
     * 标题
     */
    private String logTitle;

    /**
     * 日志内容
     */
    private String logContent;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
