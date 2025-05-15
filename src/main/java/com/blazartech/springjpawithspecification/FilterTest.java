/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazartech.springjpawithspecification;

import com.blazartech.springjpawithspecification.data.jpa.PersonEntity;
import java.util.Collection;

/**
 *
 * @author AAR1069
 */
public interface FilterTest {
    
    Collection<PersonEntity> runTest(String nameFilterString);
}
