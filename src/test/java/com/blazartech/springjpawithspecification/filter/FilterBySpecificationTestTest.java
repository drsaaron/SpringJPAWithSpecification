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
    FilterBySpecificationTestTest.FilterBySpecificationTestTestConfiguration.class
})
public class FilterBySpecificationTestTest extends FilterTestBase {
    
    private static final Logger logger = LoggerFactory.getLogger(FilterBySpecificationTestTest.class);
    
    @Configuration
    static class FilterBySpecificationTestTestConfiguration {
        
        @Bean
        public FilterBySpecificationTest instance() {
            return new FilterBySpecificationTest();
        }
    }
    
    @Autowired
    private FilterBySpecificationTest instance;
    
    public FilterBySpecificationTestTest() {
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
     * Test of runTest method, of class FilterBySpecificationTest.
     */
    @Test
    @Sql("/testData.sql")
    public void testRunTest() {
        logger.info("runTest");

        Collection<PersonEntity> result = instance.runTest("Sinclair");

        // Sinclair is in there twice, as a human and as minbari.  But the filter
        // only looks at humans and klingons, so there should be just one.
        assertEquals(1, result.size());
        
        PersonEntity sinclair = result.iterator().next();
        assertEquals(sinclair.getPersonTypCde().getPersonTypCde(), (short) 1);
    }
 
    /**
     * Test of runTest method, of class FilterBySpecificationTest.  This one should
     * find no data and simply return an empty collection rather than throwing
     * an exception or null collection.
     */
    @Test
    @Sql("/testData.sql")
    public void testRunTest_noData() {
        logger.info("runTest_noData");

        Collection<PersonEntity> result = instance.runTest("Sinclair2");

        assertNotNull(result);
        assertEquals(0, result.size());
        
    }
}
