package com.allstate.config;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.*;
import org.springframework.orm.jpa.vendor.*;
import org.springframework.transaction.*;
import org.springframework.transaction.annotation.*;
import javax.persistence.*;
import javax.sql.*;
import java.util.*;


@Configuration
@EnableTransactionManagement
@PropertySource(value = {"classpath:application.properties" })
public class JpaBeans {

    /*
     *   Note - you must also configure a Datasource bean
     *   and create an application.properties file.
     *
     *   If you wish to add additional hibernate properties in
     *   the application.properties file, edit the jpaProperties
     *   method below.
     *
     *   If you have more than 1 package to scan for entity classes
     *   You'll need to edit the factoryBean.setPackagesToScan method below,
     *   to provide an array of package names.
     *
     *   Don't forget to import this configuration file in your Application's
     *   main configuration file.
     *
     */

    @Autowired
    private Environment environment;

    @Autowired
    private DataSource dataSource;

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        return dataSource;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        return hibernateJpaVendorAdapter;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource);

        //If there is more than one package use this syntax:
        //factoryBean.setPackagesToScan(new String[] { "com.multicode.domain" });

        factoryBean.setPackagesToScan(environment.getRequiredProperty("factoryBean.packagesToScan"));
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        factoryBean.setJpaProperties(jpaProperties());
        return factoryBean;
    }

    private Properties jpaProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        return properties;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(emf);
        return txManager;
    }

}
