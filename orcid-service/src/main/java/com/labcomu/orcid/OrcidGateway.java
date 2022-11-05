package com.labcomu.orcid;

import com.labcomu.orcid.configuration.OrcidProperties;
import com.labcomu.orcid.resources.swagger.model.RecordV20;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.reactive.function.client.WebClient;

import javax.validation.constraints.NotNull;

@Component
@Validated
public class OrcidGateway {
  private final String checkServerStatusUrl;

  private final String fetchRecordDetailsUrl;

  public OrcidGateway(final OrcidProperties properties) {
    this.checkServerStatusUrl = properties.getUrl().getCheckServerStatus();
    this.fetchRecordDetailsUrl = properties.getUrl().getFetchRecordDetails();
  }

  public String getStatus() {
    return WebClient.create()
        .get()
        .uri(checkServerStatusUrl)
        .accept(MediaType.TEXT_PLAIN)
        .retrieve()
        .bodyToMono(String.class)
        .block();
  }

  public RecordV20 getOrcid(@NotNull final String orcid) {
    return WebClient.create()
        .get()
        .uri(fetchRecordDetailsUrl, orcid)
        .accept(MediaType.APPLICATION_JSON)
        .retrieve()
        .bodyToMono(RecordV20.class)
        .block();
  }
}
