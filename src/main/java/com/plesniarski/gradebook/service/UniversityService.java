package com.plesniarski.gradebook.service;

import com.plesniarski.gradebook.domain.dto.UniversityDto;
import com.plesniarski.gradebook.domain.entity.University;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UniversityService {
    List<University> findAll();
    University addUniversity(UniversityDto universityDto);
}
