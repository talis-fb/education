package com.labcomu.orcid.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(OrcidProperties.class)
public class OrcidConfiguration {}
