package com.plesniarski.gradebook.controller;

import com.plesniarski.gradebook.domain.dto.UniversityDto;
import com.plesniarski.gradebook.domain.entity.University;
import com.plesniarski.gradebook.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/university")
public class UniversityController {
    UniversityService universityService;

    @Autowired
    public UniversityController(@RequestBody UniversityService universityService) {
        this.universityService = universityService;
    }

    @CrossOrigin
    @PostMapping("/add")
    public ResponseEntity<University> addUniversity(@RequestBody UniversityDto universityDto){
        final University university = universityService.addUniversity(universityDto);
        return ResponseEntity.status(201).body(university);
    }

    @CrossOrigin
    @GetMapping("/findAll")
    public ResponseEntity<List<University>> findAll(){
        List<University> universities = universityService.findAll();
        return ResponseEntity.ok(universities);
    }
}
