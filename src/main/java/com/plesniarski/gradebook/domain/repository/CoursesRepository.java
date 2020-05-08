package com.plesniarski.gradebook.domain.repository;


import com.plesniarski.gradebook.domain.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepository extends JpaRepository<Courses, Long> {
}
