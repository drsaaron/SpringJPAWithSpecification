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
import org.springframework.data.jpa.domain.Specification;
import static org.springframework.data.jpa.domain.Specification.where;
import org.springframework.stereotype.Component;

/**
 *
 * @author AAR1069
 */
@Component
public class FilterBySpecificationTest implements FilterTest {

    @Override
    public Collection<PersonEntity> runTest(String nameFilterString) {
        logger.info("finding all by name " + nameFilterString);

        Specification<PersonEntity> nameFilter = (root, query, cb) -> cb.equal(root.get("name"), nameFilterString);                
        Specification<PersonEntity> typeFilter = (root, query, cb) -> root.get("personTypCde").get("personTypCde").in(1, 4);

        Collection<PersonEntity> personList = personRepository.findAll(where(nameFilter).and(typeFilter));

        return personList;
    }

    private static final Logger logger = LoggerFactory.getLogger(FilterBySpecificationTest.class);

    @Autowired
    private PersonEntityRepository personRepository;
}
