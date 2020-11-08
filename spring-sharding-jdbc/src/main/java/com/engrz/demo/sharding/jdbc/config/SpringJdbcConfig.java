package com.engrz.demo.sharding.jdbc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configurable
public class SpringJdbcConfig {

    @Bean
    public JdbcTemplate initJdbcTemplate(@Autowired DataSource ds) {

        return new JdbcTemplate();
    }

}
