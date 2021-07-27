package org.example.practice;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"org.example.practice"})
public class Config {
    // I should put @Bean methods only if I have a candidate bean for dependency injection
}
