package com.plesniarski.gradebook.service;

import com.plesniarski.gradebook.domain.dto.CoursesDto;
import com.plesniarski.gradebook.domain.entity.Courses;

import java.util.List;

public interface CoursesService {
    List<CoursesDto> findAll();
    Courses addCourse(CoursesDto coursesDto);
}
