package com.labcomu.orcid.model.mapper;

import com.labcomu.orcid.resources.swagger.model.EducationSummaryV20;
import com.labcomu.orcid.model.Education;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE, nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface EducationMapper {
    @Mapping(target = "role", source = "roleTitle")
    @Mapping(target = "organization", source = "organization.name")
    Education map(final EducationSummaryV20 record);
}
