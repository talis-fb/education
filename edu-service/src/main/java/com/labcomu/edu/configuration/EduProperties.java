package com.labcomu.edu.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data // @Accessors(fluent = true, chain = true)
@ConfigurationProperties(prefix = "app")
public class EduProperties {

  @Data
  public static class Url {
    private String fetchOrganizationDetails;
    private String fetchResearcherDetails;
  }

  private Url url;
}
