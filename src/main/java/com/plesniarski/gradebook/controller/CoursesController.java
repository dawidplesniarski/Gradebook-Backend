package com.plesniarski.gradebook.controller;

import com.plesniarski.gradebook.domain.dto.CoursesDto;
import com.plesniarski.gradebook.domain.entity.Courses;
import com.plesniarski.gradebook.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CoursesController {

    CoursesService coursesService;
    @Autowired
    public CoursesController(@RequestBody CoursesService coursesService){
        this.coursesService = coursesService;
    }


    @CrossOrigin
    @PostMapping("/addCourse")
    public ResponseEntity<Courses> addCourse(@RequestBody CoursesDto coursesDto){
        return ResponseEntity.ok(coursesService.addCourse(coursesDto));
    }

    @CrossOrigin
    @GetMapping("/findAll")
    public ResponseEntity<List<CoursesDto>> findAllCourses(){
        return ResponseEntity.ok(coursesService.findAll());
    }
}
