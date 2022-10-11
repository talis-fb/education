package com.labcomu.edu.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@EnableConfigurationProperties(EduProperties.class)
public class EduConfiguration {
    @Bean
    @LoadBalanced
    public WebClient.Builder builder() {
        return WebClient.builder();
    }
}
