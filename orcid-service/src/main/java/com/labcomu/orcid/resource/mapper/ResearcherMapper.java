package com.labcomu.orcid.resource.mapper;

import com.labcomu.orcid.resource.Researcher;
import com.labcomu.orcid.resources.swagger.model.NameV20;
import com.labcomu.orcid.resources.swagger.model.RecordV20;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import static org.mapstruct.NullValueMappingStrategy.RETURN_DEFAULT;
import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE, nullValueMappingStrategy = RETURN_DEFAULT, uses = EducationMapper.class)
public interface ResearcherMapper {

    @Mapping(target = "orcid", source = "orcidIdentifier.path")
    @Mapping(target = "name", source = "person.name", qualifiedByName = "mapName")
    @Mapping(target = "educations", source = "activitiesSummary.educations.educationSummary")
    Researcher map(final RecordV20 record);

    @Named("mapName")
    static String getName(final NameV20 name) {
        return name.getGivenNames().getValue() + " " + name.getFamilyName().getValue();
    }
}
