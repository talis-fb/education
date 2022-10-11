package com.labcomu.edu.model;

import lombok.Data;

import java.util.Collection;

@Data
public class Organization {
    private String name;
    private String url;
    private Collection<Researcher> researchers;
}
