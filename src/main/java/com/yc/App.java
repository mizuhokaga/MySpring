package com.yc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = "com.yc")
@Configuration
public class App {
    private ApplicationContext app;


}
