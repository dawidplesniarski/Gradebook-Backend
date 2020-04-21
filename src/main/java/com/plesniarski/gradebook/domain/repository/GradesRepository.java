package com.plesniarski.gradebook.domain.repository;

import com.plesniarski.gradebook.domain.entity.Grades;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradesRepository extends JpaRepository<Grades, Long> {
}
