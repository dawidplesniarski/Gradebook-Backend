package com.plesniarski.gradebook.service.serviceImpl;

import com.plesniarski.gradebook.domain.dto.CoursesDto;
import com.plesniarski.gradebook.domain.entity.Courses;
import com.plesniarski.gradebook.domain.repository.CoursesRepository;
import com.plesniarski.gradebook.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CoursesServiceImpl implements CoursesService {

    final CoursesRepository coursesRepository;

    @Autowired
    public CoursesServiceImpl(CoursesRepository coursesRepository) {
        this.coursesRepository = coursesRepository;
    }

    @Override
    public List<CoursesDto> findAll() {
        return coursesRepository.findAll().stream().map(Courses::dto).collect(Collectors.toList());
    }

    @Override
    public Courses addCourse(CoursesDto coursesDto) {
        Courses courses = new Courses.Builder()
                .course(coursesDto.getCourse())
                .build();
        coursesRepository.save(courses);
        return courses;
    }

    @Override
    public Optional<Courses> findById(Long id) {
        return coursesRepository.findById(id);
    }
}
