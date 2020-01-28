package com.nagarro.poc.retail.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nagarro
 * @since January 28, 2020
 */
@RestController
@RequestMapping(value = "/health/")
public class HealthCheckController {

    @RequestMapping("/check")
    public String healthCheck(){
        return "Application is up and running";
    }
}
