package com.labcomu.org.domain.repository;

import com.labcomu.org.domain.Organization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization, Long> {
    Organization getByUrl(final String url);
}
