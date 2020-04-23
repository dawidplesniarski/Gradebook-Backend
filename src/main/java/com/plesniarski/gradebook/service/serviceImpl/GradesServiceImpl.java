package com.plesniarski.gradebook.service.serviceImpl;

import com.plesniarski.gradebook.domain.converter.Converter;
import com.plesniarski.gradebook.domain.dto.GradesDto;
import com.plesniarski.gradebook.domain.entity.Grades;
import com.plesniarski.gradebook.domain.repository.GradesRepository;
import com.plesniarski.gradebook.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GradesServiceImpl implements GradeService {
    final GradesRepository gradesRepository;
    final Converter<List<Grades>,List<GradesDto>> gradesListToDto;

    @Autowired
    public GradesServiceImpl(GradesRepository gradesRepository, Converter<List<Grades>, List<GradesDto>> gradesListToDto) {
        this.gradesRepository = gradesRepository;
        this.gradesListToDto = gradesListToDto;
    }

    @Override
    public Grades addGrade(GradesDto gradesDto) {
        Grades grades = new Grades.Builder()
                .grade(gradesDto.getGrade())
                .date(LocalDateTime.now())
                .studentId(gradesDto.getStudentId())
                .build();
        gradesRepository.save(grades);

        return grades;
    }

    @Override
    public List<GradesDto> findAll() {
        return gradesRepository.findAll().stream().map(Grades::dto).collect(Collectors.toList());
    }

    @Override
    public List<GradesDto> findByStudentId(Long studentId) {
        return gradesListToDto.convert(gradesRepository.findAllByStudentId(studentId));
    }
}
