package com.multicode.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(JpaBeans.class)
@ComponentScan("com.multicode")
public class Config {
}
