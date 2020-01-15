package com.engrz.demo.sharding.jdbc.main;

import com.engrz.demo.sharding.jdbc.datasource.MasterSlaveDataSource;
import org.apache.shardingsphere.core.strategy.keygen.SnowflakeShardingKeyGenerator;

import javax.sql.DataSource;
import java.sql.*;
import java.util.logging.Logger;

/**
 * 测试分库
 */
public class MasterSlaveMain {

    private static Logger logger = Logger.getLogger(MasterSlaveMain.class.getName());

    public static void main(String[] args) {

        testMasterSlave();
        logger.info("执行完成");
    }

    /**
     *
     */
    public static void testMasterSlave() {


        try {
            MasterSlaveDataSource masterSlaveDataSource = new MasterSlaveDataSource();
            DataSource dataSource = masterSlaveDataSource.getMasterSlaveDataSource();
            testMasterWrite(dataSource);
            testSlaveRead(dataSource);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     *
     * @param dataSource
     */
    public static void testMasterWrite(DataSource dataSource) {

        try {

            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into t_user(user_id, user_name, sex, reg_date) values (?,?,?,?)");

            SnowflakeShardingKeyGenerator snowflakeShardingKeyGenerator = new SnowflakeShardingKeyGenerator();
            for (int i = 0; i < 100; i++) {
                preparedStatement.setLong(1, Long.parseLong(snowflakeShardingKeyGenerator.generateKey().toString()));
                preparedStatement.setString(2, "用户" + i);
                preparedStatement.setString(3, i % 2 == 0 ? "f" : "m");
                preparedStatement.setDate(4, new Date(System.currentTimeMillis()));
                preparedStatement.execute();
            }
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param dataSource
     */
    public static void testSlaveRead(DataSource dataSource) {

        try {

            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from t_user");

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Long userId = rs.getLong("user_id");
                logger.info("userId=" + userId);
            }
            rs.close();
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
