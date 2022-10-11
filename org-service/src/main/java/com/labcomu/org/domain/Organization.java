package com.labcomu.org.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.Collection;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.AUTO;

@Data
@Entity(name = "organization")
public class Organization {
    @Id
    @GeneratedValue(strategy = AUTO)
    @NotNull
    private Long id;

    @NotNull
    private String name;
    
    @NotNull
    private String url;

    @JsonManagedReference
    @OneToMany(cascade= ALL, fetch = LAZY, mappedBy = "organization")
    private Collection<Researcher> researchers;
}
