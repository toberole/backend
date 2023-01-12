package com.zw.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({"com.zw"})
@EnableWebMvc
@Import(SpringMvcSuport.class)
public class SpringMvcConfig {
}
