package com.plesniarski.gradebook.domain.mapper;

import com.plesniarski.gradebook.domain.converter.Converter;
import com.plesniarski.gradebook.domain.dto.UniversityDto;
import com.plesniarski.gradebook.domain.entity.University;
import org.springframework.stereotype.Component;

@Component
public class DtoToUniversityMapper implements Converter<UniversityDto, University> {
    @Override
    public University convert(UniversityDto from) {
        return new University.Builder()
                .universityName(from.getUniversityName())
                .build();
    }
}
