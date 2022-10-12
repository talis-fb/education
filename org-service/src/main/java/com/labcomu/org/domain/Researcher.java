package com.labcomu.org.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Entity(name = "researcher")
public class Researcher {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String orcid;

    @ToString.Exclude
    @ManyToOne
    private Organization organization;
}
