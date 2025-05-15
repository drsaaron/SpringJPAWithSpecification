/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazartech.springjpawithspecification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author AAR1069
 */
@SpringBootApplication
@ComponentScan("com.blazartech")
public class Main {
    
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    
    public static void main(String... args) {
        SpringApplication.run(Main.class, args);
        
        // something is holding the program up from exiting, so do a hard exit.
        // TODO: add the proper destroy methods on beans to allow a more
        // graceful shutdown.
        logger.info("done, good-bye");
        System.exit(0);
    }
}
