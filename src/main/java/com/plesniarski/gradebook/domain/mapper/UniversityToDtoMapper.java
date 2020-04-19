package com.plesniarski.gradebook.domain.mapper;

import com.plesniarski.gradebook.domain.converter.Converter;
import com.plesniarski.gradebook.domain.dto.UniversityDto;
import com.plesniarski.gradebook.domain.entity.University;
import org.springframework.stereotype.Component;

@Component
public class UniversityToDtoMapper implements Converter<University, UniversityDto> {

    @Override
    public UniversityDto convert(University from) {
        return new UniversityDto.Builder()
                .universityId(from.getUniversityId())
                .universityName(from.getUniversityName())
                .build();
    }
}
