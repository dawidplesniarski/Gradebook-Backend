package com.plesniarski.gradebook.service;

import com.plesniarski.gradebook.domain.dto.GradesDto;
import com.plesniarski.gradebook.domain.entity.Grades;

public interface GradeService {
    Grades addGrade(GradesDto gradesDto);
}
