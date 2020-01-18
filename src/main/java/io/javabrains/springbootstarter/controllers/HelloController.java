package io.javabrains.springbootstarter.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //only for GET requests
    @RequestMapping("/hello")
    public String sayHi() {
        return "Hi";
    }
}
