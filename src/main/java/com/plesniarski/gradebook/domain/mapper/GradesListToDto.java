package com.plesniarski.gradebook.domain.mapper;

import com.plesniarski.gradebook.domain.converter.Converter;
import com.plesniarski.gradebook.domain.dto.GradesDto;
import com.plesniarski.gradebook.domain.entity.Grades;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GradesListToDto implements Converter<List<Grades>, List<GradesDto>> {
    @Override
    public List<GradesDto> convert(List<Grades> from) {
        return from.stream()
                .map(grade -> {
                    return new GradesDto.Builder()
                            .id(grade.getId())
                            .grade(grade.getGrade())
                            .date(grade.getDate())
                            .studentId(grade.getStudentId())
                            .build();
                })
                .collect(Collectors.toList());
    }
}
