package com.plesniarski.gradebook.controller;

import com.plesniarski.gradebook.domain.dto.GradesDto;
import com.plesniarski.gradebook.domain.entity.Grades;
import com.plesniarski.gradebook.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@RestController
@RequestMapping("/grades")
public class GradesController {

    final GradeService gradeService;

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }

    @Autowired
    public GradesController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @CrossOrigin
    @PostMapping("/addGrade")
    public ResponseEntity<Grades> addGrade(@RequestBody GradesDto gradesDto){
        final Grades grades = gradeService.addGrade(gradesDto);
        return ResponseEntity.ok(grades);
    }
    @CrossOrigin
    @GetMapping("/findAllGrades")
    public ResponseEntity<List<GradesDto>> findAll(){
        List<GradesDto> grades = gradeService.findAll();
        return ResponseEntity.ok(grades);
    }
    @CrossOrigin
    @GetMapping("/findStudentGrades/{id}")
    public ResponseEntity<List<GradesDto>> getStudentGrades(@PathVariable Long id){
        final List<GradesDto> grades = gradeService.findByStudentId(id);
        return ResponseEntity.ok(grades);
    }
}
