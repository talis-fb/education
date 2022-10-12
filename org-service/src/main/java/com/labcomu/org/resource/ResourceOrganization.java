package com.labcomu.org.resource;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import java.util.Collection;

@Data
public class ResourceOrganization {
    private Long id;
    private String name;
    private String url;

    @JsonManagedReference
    private Collection<ResourceResearcher> researchers;
}
