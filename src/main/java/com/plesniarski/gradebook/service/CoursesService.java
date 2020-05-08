package com.plesniarski.gradebook.service;

import com.plesniarski.gradebook.domain.dto.CoursesDto;
import com.plesniarski.gradebook.domain.entity.Courses;

import java.util.List;
import java.util.Optional;

public interface CoursesService {
    List<CoursesDto> findAll();
    Courses addCourse(CoursesDto coursesDto);
    Optional<Courses> findById(Long id);
}
