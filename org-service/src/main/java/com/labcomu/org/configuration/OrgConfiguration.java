package com.labcomu.org.configuration;

import lombok.SneakyThrows;
import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.sql.SQLException;

@Configuration
public class OrgConfiguration {

    //@SneakyThrows
    @Profile("default")
    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server h2Server() {
        try {
            return Server.createTcpServer();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
