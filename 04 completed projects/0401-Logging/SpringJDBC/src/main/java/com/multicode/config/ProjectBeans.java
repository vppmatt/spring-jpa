package com.multicode.config;

import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.*;

import javax.sql.*;

@Configuration
public class ProjectBeans {

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/payments");
        dataSource.setUsername("root");
        dataSource.setPassword("password");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return dataSource;
    }
}
