package com.zw.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({JdbcConfig.class})
public class SpringConfig1 {

}
