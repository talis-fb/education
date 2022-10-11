package com.labcomu.org.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static javax.persistence.GenerationType.AUTO;

@Data
@Entity(name = "researcher")
public class Researcher {
    @Id
    @GeneratedValue(strategy = AUTO)
    @NotNull
    private Long id;

    @NotNull
    private String orcid;

    @JsonBackReference
    @NotNull
    @ManyToOne
    private Organization organization;
}
