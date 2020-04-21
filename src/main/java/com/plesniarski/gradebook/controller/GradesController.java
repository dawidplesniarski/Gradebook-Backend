package com.plesniarski.gradebook.controller;

import com.plesniarski.gradebook.domain.dto.GradesDto;
import com.plesniarski.gradebook.domain.entity.Grades;
import com.plesniarski.gradebook.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grades")
public class GradesController {

    final GradeService gradeService;

    @Autowired
    public GradesController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @PostMapping("/addGrade")
    public ResponseEntity<Grades> addGrade(@RequestBody GradesDto gradesDto){
        final Grades grades = gradeService.addGrade(gradesDto);
        return ResponseEntity.ok(grades);
    }
    @GetMapping("/getAllGrades")
    public ResponseEntity<List<GradesDto>> findAll(){
        List<GradesDto> grades = gradeService.findAll();
        return ResponseEntity.ok(grades);
    }
}
