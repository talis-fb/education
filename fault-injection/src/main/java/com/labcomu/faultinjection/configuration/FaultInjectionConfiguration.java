package com.labcomu.faultinjection.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.expression.spel.standard.SpelExpressionParser;

@Configuration
@EnableAspectJAutoProxy
public class FaultInjectionConfiguration {
    @Bean
    public SpelExpressionParser parser() {
        return new SpelExpressionParser();
    }
}
