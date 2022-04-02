package com.templar.javatraining.assemble;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanCConfig {

    @Bean
    public BeanC beanC() {
        return new BeanC(3, "beanC123");
    }
}
