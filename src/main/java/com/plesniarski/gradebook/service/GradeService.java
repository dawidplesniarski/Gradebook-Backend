package com.plesniarski.gradebook.service;

import com.plesniarski.gradebook.domain.dto.GradesDto;
import com.plesniarski.gradebook.domain.entity.Grades;

import java.util.List;

public interface GradeService {
    Grades addGrade(GradesDto gradesDto);
    List<GradesDto> findAll();
    List<GradesDto> findByStudentId(Long studentId);
    void deleteGrade(Long gradeId);
}
