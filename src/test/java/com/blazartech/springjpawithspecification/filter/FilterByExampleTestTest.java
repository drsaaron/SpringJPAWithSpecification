/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazartech.springjpawithspecification.filter;

import com.blazartech.springjpawithspecification.data.jpa.PersonEntity;
import java.util.Collection;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 *
 * @author AAR1069
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
    FilterByExampleTestTest.FilterByExampleTestTestConfiguration.class,
})
public class FilterByExampleTestTest extends FilterTestBase {
    
    private static final Logger logger = LoggerFactory.getLogger(FilterByExampleTestTest.class);
    
    @Configuration
    static class FilterByExampleTestTestConfiguration {
        
        @Bean
        public FilterByExampleTest instance() {
            return new FilterByExampleTest();
        }
    }
    
    @Autowired
    private FilterByExampleTest instance;
    
    public FilterByExampleTestTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
    }
    
    @AfterEach
    @Override
    public void tearDown() {
        super.tearDown();
    }

    /**
     * Test of runTest method, of class FilterByExampleTest.
     */
    @Test
    @Sql("/testData.sql")
    public void testRunTest() {
        logger.info("runTest");
        
        String nameFilterString = "a";
        Collection<PersonEntity> result = instance.runTest(nameFilterString);
        assertEquals(5, result.size());
    }
    
    @Test
    @Sql("/testData.sql")
    public void testRunTest_noData() {
        logger.info("runTest_noData");
        
        String nameFilterString = "x";
        Collection<PersonEntity> result = instance.runTest(nameFilterString);
        assertNotNull(result);
        assertEquals(0, result.size());
    }
}
