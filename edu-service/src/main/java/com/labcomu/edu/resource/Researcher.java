package com.labcomu.edu.resource;

import lombok.Data;

import java.util.Collection;

@Data
public class Researcher {
    private String orcid;
    private String name;
    private Collection<Education> educations;
}
