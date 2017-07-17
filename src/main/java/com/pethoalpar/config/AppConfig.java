package com.pethoalpar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;

import java.util.concurrent.Executors;

/**
 * Created by petho on 2017-07-17.
 */
@Configuration
@EnableAsync
@ComponentScan(basePackages = "com.pethoalpar.beans")
public class AppConfig {

    @Bean
    public TaskExecutor taskExecutor(){
        return new ConcurrentTaskExecutor(Executors.newFixedThreadPool(3));
    }
}
