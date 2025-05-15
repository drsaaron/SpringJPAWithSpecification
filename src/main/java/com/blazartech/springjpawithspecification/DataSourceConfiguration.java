/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazartech.springjpawithspecification;

import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author AAR1069
 */
@Configuration
@PropertySource("classpath:application-persistence.properties")
public class DataSourceConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(DataSourceConfiguration.class);
    
    @Value("${db.user}")
    private String userID;
    
    @Value("${db.resource}")
    private String resourceID;
    
    @Value("${db.url}")
    private String url;
    
    @Value("${db.driverClass}")
    private String driverClass;
    
    @Bean
    public DataSource dataSource() {
        logger.info("configuring data source for " + url);
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(driverClass);
        ds.setUrl(url);
        ds.setUsername(userID);
        ds.setPassword(resourceID);
        return ds;
    }
}
