package com.engrz.commons.sharding.jdbc;

import java.util.HashMap;
import java.util.Map;

/**
 * 分表管理
 */
public class ShardingTableManager {

    private static Map<String, ShardingDateUtil.ShardingDateUnit> dataModuloShardingMap = new HashMap<>();

    /**
     * 设置日期分表规则
     * @param tableName
     * @param unit
     */
    public static void addDataModuloSharding(String tableName, ShardingDateUtil.ShardingDateUnit unit) {

        dataModuloShardingMap.put(tableName, unit);
    }

    /**
     * 获取日期分表规则
     * @param tableName
     * @return
     */
    public static ShardingDateUtil.ShardingDateUnit getDataModuloSharding(String tableName) {

        return dataModuloShardingMap.get(tableName);
    }

}
