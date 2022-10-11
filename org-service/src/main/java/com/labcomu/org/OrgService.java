package com.labcomu.org;

import com.labcomu.org.domain.Organization;
import com.labcomu.org.domain.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Service
@Validated
@RequiredArgsConstructor
public class OrgService {
    private final OrganizationRepository organizationRepository;

    public Organization getOrganization(@NotNull final String url) {
        return organizationRepository.getByUrl(url);
    }
}
