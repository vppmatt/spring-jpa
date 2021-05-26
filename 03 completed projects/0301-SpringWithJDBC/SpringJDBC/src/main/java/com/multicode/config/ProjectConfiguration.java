package com.multicode.config;

import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.*;

import javax.sql.DataSource;

@Configuration
@Import(ProjectBeans.class)
@ComponentScan("com.multicode")
public class ProjectConfiguration {
}
