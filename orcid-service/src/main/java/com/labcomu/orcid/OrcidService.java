package com.labcomu.orcid;

import com.labcomu.orcid.model.mapper.ResearcherMapper;
import com.labcomu.orcid.model.Researcher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

import static org.apache.commons.lang.StringUtils.isNotEmpty;

@Service
@Validated
@RequiredArgsConstructor
public class OrcidService {
    /*@Delegate*/ private final OrcidGateway gateway;
    private final ResearcherMapper researcherMapper;

    public boolean isActive() {
        return isNotEmpty(gateway.getStatus());
    }

    public Researcher getResearcher(@NotNull final String orcid) {
        return researcherMapper.map(gateway.getOrcid(orcid));
    }
}
