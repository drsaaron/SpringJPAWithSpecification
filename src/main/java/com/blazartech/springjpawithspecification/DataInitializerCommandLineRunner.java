/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blazartech.springjpawithspecification;

import com.blazartech.springjpawithspecification.data.jpa.PersonEntity;
import com.blazartech.springjpawithspecification.data.jpa.PersonTypValEntity;
import com.blazartech.springjpawithspecification.data.jpa.repos.PersonEntityRepository;
import com.blazartech.springjpawithspecification.data.jpa.repos.PersonTypValEntityRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 *
 * @author aar1069
 */
@Component
@Order(1)
public class DataInitializerCommandLineRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DataInitializerCommandLineRunner.class);
    
    @Autowired
    private PersonEntityRepository personRepo;
    
    @Autowired
    private PersonTypValEntityRepository personTypValRepo;
    
    @Override
    @Transactional
    public void run(String... args) throws Exception {
        logger.info("initializing data");
        
        PersonTypValEntity human = new PersonTypValEntity((short) 1, "Human");
        PersonTypValEntity minbari = new PersonTypValEntity((short) 2, "Minbari");
        PersonTypValEntity klingon = new PersonTypValEntity((short) 3, "Klingon");
        PersonTypValEntity angel = new PersonTypValEntity((short) 4, "Angel");
        
        List<PersonTypValEntity> typeCodes = List.of(human, minbari, klingon, angel);
        personTypValRepo.saveAll(typeCodes);
        
        List<PersonEntity> people = List.of(
                new PersonEntity("Sinclair", human),
                new PersonEntity("Sinclair", minbari),
                new PersonEntity("Delenn", minbari),
                new PersonEntity("Worf", klingon),
                new PersonEntity("Sheridan", human),
                new PersonEntity("Scott", human),
                new PersonEntity("Pauline", human),
                new PersonEntity("Pauline", angel)
        );
        personRepo.saveAll(people);
    }
    
}
