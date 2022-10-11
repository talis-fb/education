package com.labcomu.orcid.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data // @Accessors(fluent = true, chain = true)
@ConfigurationProperties(prefix = "app")
public class OrcidProperties {

  @Data
  public static class Url {
    private String checkServerStatus;
    private String fetchRecordDetails;
  }

  private Url url;
}
