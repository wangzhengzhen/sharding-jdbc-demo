package com.engrz.demo.sharding.jdbc.main;

import com.engrz.demo.sharding.jdbc.datasource.ShardingDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * 测试分片
 */
public class ShardingMain {

    private static Logger logger = Logger.getLogger(ShardingMain.class.getName());

    public static void main(String[] args) {

        testSharding();
        logger.info("执行完成");
    }

    public static void testSharding() {

        try {
            ShardingDataSource shardingDataSource = new ShardingDataSource();
            DataSource dataSource = shardingDataSource.getShardingDataSource();
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into t_user(user_name, sex, reg_date) values (?,?,?)");

            for (int i = 0; i < 100; i++) {
//                StringBuffer sql = new StringBuffer("insert into t_user(user_id, user_name, sex) values (");
//                sql.append(new SnowflakeShardingKeyGenerator().generateKey().toString());
//                sql.append(",'").append("用户" + i).append("'");
//                sql.append(",'").append(i % 2 == 0 ? "f" : "m").append("'");
//                sql.append(",'").append("2020-01-15").append("'");
//                sql.append(")");
//                logger.info(sql.toString());
//                statement.execute(sql.toString());
//                preparedStatement.setLong(1, Long.parseLong(new SnowflakeShardingKeyGenerator().generateKey().toString()));
                preparedStatement.setString(1, "用户" + i);
                preparedStatement.setString(2, i % 2 == 0 ? "f" : "m");
                preparedStatement.setDate(3, new Date(System.currentTimeMillis()));
                preparedStatement.execute();
            }
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
