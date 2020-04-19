package com.plesniarski.gradebook.controller;

import com.plesniarski.gradebook.domain.dto.UniversityDto;
import com.plesniarski.gradebook.domain.entity.University;
import com.plesniarski.gradebook.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/university")
public class UniversityController {
    UniversityService universityService;

    @Autowired
    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @PostMapping("/add")
    public ResponseEntity<UniversityDto> addUniversity(University university){

        return null;
    }
}
