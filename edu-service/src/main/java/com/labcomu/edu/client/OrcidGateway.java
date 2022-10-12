package com.labcomu.edu.client;

import com.labcomu.edu.configuration.EduProperties;
import com.labcomu.edu.resource.Researcher;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreakerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.reactive.function.client.WebClient;

import javax.validation.constraints.NotNull;

@Component
@Validated
public class OrcidGateway {
    private static final String ID = "orcid";
    private final String fetchResearcherUrl;

    private final ReactiveCircuitBreaker circuitBreaker;

    private final WebClient.Builder webClientBuilder;

    public OrcidGateway(final WebClient.Builder webClientBuilder,
            final EduProperties properties, final ReactiveCircuitBreakerFactory<?, ?> factory) {
        this.webClientBuilder = webClientBuilder;
        this.fetchResearcherUrl = properties.getUrl().getFetchResearcherDetails();
        this.circuitBreaker = factory.create(ID);
    }

    public Researcher getResearcher(@NotNull final String orcid) {
        return webClientBuilder.build()
                .get()
                .uri(fetchResearcherUrl, orcid)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Researcher.class)
                .transform(circuitBreaker::run)
                .block();
    }
}
