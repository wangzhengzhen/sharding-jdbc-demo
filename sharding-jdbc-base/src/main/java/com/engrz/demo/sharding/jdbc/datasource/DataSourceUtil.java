package com.engrz.demo.sharding.jdbc.datasource;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

public class DataSourceUtil {

    private static final String HOST = "localhost";

    private static final int PORT = 3306;

    private static final String USER_NAME = "root";

    private static final String PASSWORD = "123456";

    public static DataSource createDataSource(final String dataSourceName) {
        BasicDataSource result = new BasicDataSource();
        result.setDriverClassName(com.mysql.cj.jdbc.Driver.class.getName());
        result.setUrl(String.format("jdbc:mysql://localhost:3306/"+dataSourceName+"?useSSL=false&useUnicode=true&characterEncoding=utf8&autoReconnect=true&serverTimezone=Asia/Shanghai", HOST, PORT, dataSourceName));
        result.setUsername(USER_NAME);
        result.setPassword(PASSWORD);
        return result;
    }

}
