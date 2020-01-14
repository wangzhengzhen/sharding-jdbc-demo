package com.engrz.demo.sharding.jdbc;

public class Main {

    public static void main(String[] args) {

        JdbcConfig jdbcConfig = new JdbcConfig();
        jdbcConfig.initDatasourceForYaml();
    }
}
