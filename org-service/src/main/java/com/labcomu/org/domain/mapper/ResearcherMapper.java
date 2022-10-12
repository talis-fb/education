package com.labcomu.org.domain.mapper;

import com.labcomu.org.domain.Researcher;
import com.labcomu.org.resource.ResourceResearcher;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.NullValueMappingStrategy.RETURN_DEFAULT;
import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE, nullValueMappingStrategy = RETURN_DEFAULT)
@DecoratedWith(ResearcherMapperDecorator.class)
public interface ResearcherMapper {
    @Mapping(target = "organization", ignore = true)
    Researcher map(final ResourceResearcher researcher);
}
