package com.zw.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
// 加载properties文件
@PropertySource({"jdbc.properties","jdbc1.properties"})
@ComponentScan("com.zw")
public class SpringConfig {
}
