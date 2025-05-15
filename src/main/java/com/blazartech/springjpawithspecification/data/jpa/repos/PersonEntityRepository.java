/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazartech.springjpawithspecification.data.jpa.repos;

import com.blazartech.springjpawithspecification.data.jpa.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 *
 * @author AAR1069
 */
@Repository
public interface PersonEntityRepository extends JpaRepository<PersonEntity, Long>, JpaSpecificationExecutor<PersonEntity> {
    
}
