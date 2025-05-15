/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazartech.springjpawithspecification.filter;

import com.blazartech.springjpawithspecification.DataSourceConfiguration;
import com.blazartech.springjpawithspecification.EntityManagerConfiguration;
import com.blazartech.springjpawithspecification.JpaVendorAdapterConfiguration;
import com.blazartech.springjpawithspecification.TransactionManagerConfiguration;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;

/**
 *
 * @author AAR1069
 */
@ContextConfiguration(classes = {
    FilterTestBase.FilterTestBaseConfiguration.class,
    DataSourceConfiguration.class,
    EntityManagerConfiguration.class,
    JpaVendorAdapterConfiguration.class,
    TransactionManagerConfiguration.class
})
@Transactional
abstract public class FilterTestBase {
    
    @Configuration
    @EnableJpaRepositories(basePackages = "com.blazartech.springjpawithspecification.data.jpa.repos")
    static class FilterTestBaseConfiguration {
        
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }
    
}
