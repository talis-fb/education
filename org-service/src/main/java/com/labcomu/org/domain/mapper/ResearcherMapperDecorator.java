package com.labcomu.org.domain.mapper;

import com.labcomu.org.domain.Organization;
import com.labcomu.org.domain.Researcher;
import com.labcomu.org.domain.repository.OrganizationRepository;
import com.labcomu.org.resource.ResourceOrganization;
import com.labcomu.org.resource.ResourceResearcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class ResearcherMapperDecorator implements ResearcherMapper {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    @Qualifier("delegate")
    private ResearcherMapper delegate;

    @Override
    public Researcher map(final ResourceResearcher resourceResearcher) {
        Researcher researcher = delegate.map(resourceResearcher);
        researcher.setOrganization(getOrganization(resourceResearcher.getOrganization()));

        return researcher;
    }

    private Organization getOrganization(final ResourceOrganization organization) {
        if (organization == null)
            return null;

        return organizationRepository.findById(organization.getId()).orElse(null);
    }
}
