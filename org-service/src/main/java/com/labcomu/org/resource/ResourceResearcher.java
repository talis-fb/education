package com.labcomu.org.resource;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.ToString;

@Data
public class ResourceResearcher {
    private Long id;
    private String orcid;

    @JsonBackReference
    @ToString.Exclude
    private ResourceOrganization organization;
}
