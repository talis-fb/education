package com.labcomu.orcid;

import com.labcomu.orcid.configuration.OrcidProperties;
import com.labcomu.orcid.resources.swagger.model.RecordV20;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreakerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.validation.constraints.NotNull;

@Component
@Validated
public class OrcidGateway {
  private static final String ID = "orcid";

  private final String checkServerStatusUrl;

  private final String fetchRecordDetailsUrl;

  private final ReactiveCircuitBreaker circuitBreaker;

  public OrcidGateway(
          final OrcidProperties properties, final ReactiveCircuitBreakerFactory<?, ?> factory) {
    this.checkServerStatusUrl = properties.getUrl().getCheckServerStatus();
    this.fetchRecordDetailsUrl = properties.getUrl().getFetchRecordDetails();
    this.circuitBreaker = factory.create(ID);
  }

  public String getStatus() {
    return WebClient.create()
        .get()
        .uri(checkServerStatusUrl)
        .accept(MediaType.TEXT_PLAIN)
        .retrieve()
        .bodyToMono(String.class)
        .transform(mono -> circuitBreaker.run(mono, throwable -> Mono.just("Error")))
        .block();
  }

  public RecordV20 getOrcid(@NotNull final String orcid) {
    return WebClient.create()
        .get()
        .uri(fetchRecordDetailsUrl, orcid)
        .accept(MediaType.APPLICATION_JSON)
        .retrieve()
        .bodyToMono(RecordV20.class)
        .transform(circuitBreaker::run)
        .block();
  }
}
