package com.labcomu.edu.client;

import com.labcomu.edu.configuration.EduProperties;
import com.labcomu.edu.model.Organization;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreakerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.reactive.function.client.WebClient;

import javax.validation.constraints.NotNull;

@Component
@Validated
public class OrgGateway {
    private static final String ID = "org";
    private final String fetchOrganizationUrl;

    private final ReactiveCircuitBreaker circuitBreaker;

    private final WebClient.Builder webClientBuilder;

    public OrgGateway(final WebClient.Builder webClientBuilder,
            final EduProperties properties, final ReactiveCircuitBreakerFactory<?, ?> factory) {
        this.webClientBuilder = webClientBuilder;
        this.fetchOrganizationUrl = properties.getUrl().getFetchOrganizationDetails();
        this.circuitBreaker = factory.create(ID);
    }

    public Organization getOrganization(@NotNull final String url) {
        return webClientBuilder.build()
                .get()
                .uri(fetchOrganizationUrl, url)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Organization.class)
                .transform(circuitBreaker::run)
                .block();
    }
}
