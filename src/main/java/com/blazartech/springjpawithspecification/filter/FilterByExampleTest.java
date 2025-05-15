/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazartech.springjpawithspecification.filter;

import com.blazartech.springjpawithspecification.FilterTest;
import com.blazartech.springjpawithspecification.data.jpa.PersonEntity;
import com.blazartech.springjpawithspecification.data.jpa.repos.PersonEntityRepository;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;

/**
 *
 * @author AAR1069
 */
@Component
public class FilterByExampleTest implements FilterTest {

    private static final Logger logger = LoggerFactory.getLogger(FilterByExampleTest.class);

    @Autowired
    private PersonEntityRepository personRepository;
    
    @Override
    public Collection<PersonEntity> runTest(String nameFilterString) {
        logger.info("finding by name example, sub_name = " + nameFilterString);

        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains());
//        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("name", ExampleMatcher.GenericPropertyMatchers.exact());
        PersonEntity pe = new PersonEntity();
        pe.setName(nameFilterString);
        Example<PersonEntity> example = Example.of(pe, matcher);

        Collection<PersonEntity> personList = personRepository.findAll(example);
        return personList;
    }

}
