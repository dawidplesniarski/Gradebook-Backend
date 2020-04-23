package com.plesniarski.gradebook.domain.repository;

import com.plesniarski.gradebook.domain.entity.Grades;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GradesRepository extends JpaRepository<Grades, Long> {
    List<Grades> findAllByStudentId(Long id);
}
