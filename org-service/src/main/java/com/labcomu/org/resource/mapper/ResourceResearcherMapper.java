package com.labcomu.org.resource.mapper;


import com.labcomu.org.domain.Researcher;
import com.labcomu.org.resource.ResourceResearcher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.NullValueMappingStrategy.RETURN_DEFAULT;
import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE, nullValueMappingStrategy = RETURN_DEFAULT)
public interface ResourceResearcherMapper {

    @Mapping(target="organization", ignore = true)
    ResourceResearcher map(final Researcher researcher/*, @Context CycleAvoidingMappingContext context*/);
}
