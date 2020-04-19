package com.plesniarski.gradebook.domain.repository;

import com.plesniarski.gradebook.domain.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends JpaRepository<University, Long> {
}
