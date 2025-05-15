/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.blazartech.springjpawithspecification.data.jpa.repos;

import com.blazartech.springjpawithspecification.data.jpa.PersonTypValEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 *
 * @author aar1069
 */
public interface PersonTypValEntityRepository extends JpaRepository<PersonTypValEntity, Short>, JpaSpecificationExecutor<PersonTypValEntity> {
    
}
