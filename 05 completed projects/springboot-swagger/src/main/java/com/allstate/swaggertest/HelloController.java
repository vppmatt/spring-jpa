package com.allstate.swaggertest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    @GetMapping("/api/allstate")
    public String sayHello() {
        return "Welcome to Swagger";
    }
}
