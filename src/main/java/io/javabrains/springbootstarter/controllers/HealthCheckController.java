package io.javabrains.springbootstarter.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @RequestMapping("/ping")
    public String healthCheck(){
        return "OK. We're online.";
    }
}
