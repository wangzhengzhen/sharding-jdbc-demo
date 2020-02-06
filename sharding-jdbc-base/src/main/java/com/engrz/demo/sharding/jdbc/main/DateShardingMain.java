package com.engrz.demo.sharding.jdbc.main;

import com.engrz.demo.sharding.jdbc.datasource.DateShardingDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Random;
import java.util.logging.Logger;

/**
 * 测试分片
 */
public class DateShardingMain {

    private static Logger logger = Logger.getLogger(DateShardingMain.class.getName());

    public static void main(String[] args) {

        testSharding();
        logger.info("执行完成");
    }

    public static void testSharding() {

        try {
            DateShardingDataSource shardingDataSource = new DateShardingDataSource();
            DataSource dataSource = shardingDataSource.getShardingDataSource();
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into t_log(log_id, log_level, log_title, log_content, create_time) values (?,?,?,?,?)");

            Calendar c = Calendar.getInstance();
            int[] yearArray = new int[]{2016,2017,2018,2019,2020};

            int id = 1;
            for (int i = 0; i < 100; i++) {
                preparedStatement.setInt(1, id++);
                preparedStatement.setInt(2, 1);
                preparedStatement.setString(3, "title" + i);
                preparedStatement.setString(4, "content" + i);
                int index = new Random().nextInt(yearArray.length);
                c.set(Calendar.YEAR, yearArray[index]);
                preparedStatement.setDate(5, new java.sql.Date(c.getTimeInMillis()));
                preparedStatement.execute();
            }
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
