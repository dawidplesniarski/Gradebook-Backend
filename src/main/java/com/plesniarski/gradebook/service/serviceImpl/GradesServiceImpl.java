package com.plesniarski.gradebook.service.serviceImpl;

import com.plesniarski.gradebook.domain.dto.GradesDto;
import com.plesniarski.gradebook.domain.entity.Grades;
import com.plesniarski.gradebook.domain.repository.GradesRepository;
import com.plesniarski.gradebook.service.GradeService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class GradesServiceImpl implements GradeService {
    final GradesRepository gradesRepository;

    @Autowired
    public GradesServiceImpl(GradesRepository gradesRepository) {
        this.gradesRepository = gradesRepository;
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
}
