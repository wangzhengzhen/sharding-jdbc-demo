package com.engrz.demo.sharding.jdbc.main;

import com.engrz.demo.sharding.jdbc.datasource.EncryptDataSource;
import org.apache.shardingsphere.core.strategy.keygen.SnowflakeShardingKeyGenerator;

import javax.sql.DataSource;
import java.sql.*;
import java.util.logging.Logger;

/**
 * 数据脱敏测试
 */
public class EncryptMain {

    private static Logger logger = Logger.getLogger(EncryptMain.class.getName());

    public static void main(String[] args) {

        testEncrypt();
        logger.info("执行完成");
    }

    public static void testEncrypt() {

        try {
            EncryptDataSource encryptDataSource = new EncryptDataSource();
            DataSource dataSource = encryptDataSource.getEncryptDataSource();

            testInsert(dataSource);
            testQuery(dataSource);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void testInsert(DataSource dataSource) {

        try {

            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into t_user(user_id, user_name, pwd, sex, reg_date) values (?,?,?,?,?)");

            SnowflakeShardingKeyGenerator snowflakeShardingKeyGenerator = new SnowflakeShardingKeyGenerator();
            for (int i = 0; i < 100; i++) {
                preparedStatement.setLong(1, Long.parseLong(snowflakeShardingKeyGenerator.generateKey().toString()));
                preparedStatement.setString(2, "用户" + i);
                preparedStatement.setString(3, "000000");
                preparedStatement.setString(4, i % 2 == 0 ? "f" : "m");
                preparedStatement.setDate(5, new Date(System.currentTimeMillis()));
                preparedStatement.execute();
            }
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void testQuery(DataSource dataSource) {
        try {

            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from t_user where pwd=?");

            preparedStatement.setString(1, "000000");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Long userId = rs.getLong("user_id");
                logger.info("userId=" + userId + ", pwd=" + rs.getString("pwd"));
            }
            rs.close();
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
