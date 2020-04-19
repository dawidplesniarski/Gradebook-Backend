package com.plesniarski.gradebook.service;

import com.plesniarski.gradebook.domain.dto.UniversityDto;
import com.plesniarski.gradebook.domain.entity.University;
import org.springframework.stereotype.Service;

@Service
public interface UniversityService {
    UniversityDto addUniversity(University university);
}
