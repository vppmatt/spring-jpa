package com.multicode.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@Import(JpaBeans.class)
@ComponentScan("com.multicode")
@EnableJpaRepositories("com.multicode.repositories")
public class Config {
}
