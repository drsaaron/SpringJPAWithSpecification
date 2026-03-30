/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazartech.springjpawithspecification;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

/**
 *
 * @author AAR1069
 */
@Configuration
public class EntityManagerConfiguration {

    @Autowired
    private DataSource dataSource;
    
    @Autowired
    private JpaVendorAdapter jpaVendorAdapter;
    
    @Autowired
    private Environment env;
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean f = new LocalContainerEntityManagerFactoryBean();
        f.setDataSource(dataSource);
        f.setPersistenceXmlLocation("classpath:META-INF/persistence.xml");
        f.setJpaVendorAdapter(jpaVendorAdapter);
        f.setPersistenceUnitName("com.blazartech_SpringJPAWithSpecification_jar_1.0-SNAPSHOTPU");
        
        return f;
    }
}
