package com.multicode.config;

import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.*;

@Configuration
@Import({ProjectBeans.class, JpaBeans.class})
@ComponentScan("com.multicode")
@EnableJpaRepositories("com.multicode.repositories")
@EnableAspectJAutoProxy
public class ProjectConfiguration {
}
