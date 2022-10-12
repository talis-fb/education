package com.labcomu.org.resource.mapper;


import com.labcomu.org.domain.Organization;
import com.labcomu.org.resource.ResourceOrganization;
import org.mapstruct.Mapper;

import static org.mapstruct.NullValueMappingStrategy.RETURN_DEFAULT;
import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE, nullValueMappingStrategy = RETURN_DEFAULT, uses = ResourceResearcherMapper.class)
public interface ResourceOrganizationMapper {
    ResourceOrganization map(final Organization organization/*, @Context CycleAvoidingMappingContext context*/);
}
