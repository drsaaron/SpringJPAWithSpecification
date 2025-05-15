/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazartech.springjpawithspecification;

import com.blazartech.springjpawithspecification.data.jpa.PersonEntity;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author AAR1069
 */
@Component
public class ListByNameSpecificationCommandLineRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(ListByNameSpecificationCommandLineRunner.class);

    private static final String NAME = "Pauline";

    @Autowired
    private FilterTest filterBySpecificationTest;
    
    @Override
    public void run(String... args) throws Exception {
        logger.info("finding all by name " + NAME);

        Collection<PersonEntity> personList = filterBySpecificationTest.runTest(NAME);
        personList.forEach((p) -> {
            logger.info("found person " + p);
        });
    }

}
