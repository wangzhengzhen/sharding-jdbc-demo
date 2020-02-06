package com.engrz.demo.sharding.jdbc.datasource;

import com.engrz.demo.sharding.jdbc.algorithm.DatePreciseModuloShardingTableAlgorithm;
import com.engrz.demo.sharding.jdbc.algorithm.DateRangeModuloShardingTableAlgorithm;
import com.engrz.demo.sharding.jdbc.algorithm.PreciseModuloShardingDatabaseAlgorithm;
import org.apache.shardingsphere.api.config.sharding.KeyGeneratorConfiguration;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.InlineShardingStrategyConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.StandardShardingStrategyConfiguration;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 数据分片
 */
public class DateShardingDataSource {

    public DataSource getShardingDataSource() throws SQLException {
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        shardingRuleConfig.getTableRuleConfigs().add(getLogTableRuleConfiguration());
        shardingRuleConfig.setDefaultDatabaseShardingStrategyConfig(new InlineShardingStrategyConfiguration("create_time", "ds0"));
//        shardingRuleConfig.setDefaultTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("user_id", "t_user${user_id % 2}"));
        shardingRuleConfig.setDefaultTableShardingStrategyConfig(new StandardShardingStrategyConfiguration("create_time", new DatePreciseModuloShardingTableAlgorithm(), new DateRangeModuloShardingTableAlgorithm()));
        return ShardingDataSourceFactory.createDataSource(createDataSourceMap(), shardingRuleConfig, new Properties());
    }

    public TableRuleConfiguration getLogTableRuleConfiguration() {
        TableRuleConfiguration result = new TableRuleConfiguration("t_log", "ds0.t_log_${2016..2020}");
        return result;
    }

    public Map<String, DataSource> createDataSourceMap() {
        Map<String, DataSource> result = new HashMap<>();
        result.put("ds0", DataSourceUtil.createDataSource("ds0"));
        return result;
    }

}
