package com.multicode.config;

import org.springframework.context.annotation.*;

@Configuration
@Import({ProjectBeans.class, JpaBeans.class})
@ComponentScan("com.multicode")
public class ProjectConfiguration {
}
