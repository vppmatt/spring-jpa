package com.multicode.config;

import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@Import({ProjectBeans.class, JpaBeans.class})
@ComponentScan("com.multicode")
@EnableJpaRepositories("com.multicode")
public class ProjectConfiguration {
}
