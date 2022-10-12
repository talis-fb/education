package com.labcomu.org.domain.repository;

import com.labcomu.org.domain.Researcher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Repository
public interface ResearcherRepository extends CrudRepository<Researcher, Long> {
    boolean existsByOrcid(@NotNull final String orcid);
}
