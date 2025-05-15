/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazartech.springjpawithspecification.filter;

import com.blazartech.springjpawithspecification.FilterTest;
import com.blazartech.springjpawithspecification.data.jpa.PersonEntity;
import java.util.Collection;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author AAR1069
 */
@Component
public class FilterByOQLTest implements FilterTest {

    private static final Logger logger = LoggerFactory.getLogger(FilterByOQLTest.class);
    
    @Autowired
    private EntityManager em;
    
    @Override
    public Collection<PersonEntity> runTest(String nameFilterString) {
        logger.info("getting by name = " + nameFilterString);
        
        TypedQuery<PersonEntity> q = em.createQuery("select p from PersonEntity p where p.name = :name", PersonEntity.class);
        q.setParameter("name", nameFilterString);
        
        Collection<PersonEntity> personList = q.getResultList();    
        return personList;
    }
}
