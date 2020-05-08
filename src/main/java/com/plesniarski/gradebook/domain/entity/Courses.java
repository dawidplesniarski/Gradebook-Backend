package com.plesniarski.gradebook.domain.entity;

import com.plesniarski.gradebook.domain.dto.CoursesDto;

import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String course;

    public Courses(){}

    public Courses(Builder builder){
        id = builder.id;
        course = builder.course;
    }

    public Long getId() {
        return id;
    }

    public String getCourse() {
        return course;
    }

    public static final class Builder{
        private Long id;
        private String course;

        public Builder id(Long id){
            this.id = id;
            return this;
        }
        public Builder course(String course){
            this.course = course;
            return this;
        }
        public Courses build(){
            return new Courses(this);
        }
    }
    public CoursesDto dto(){
        return new CoursesDto.Builder()
                .id(getId())
                .course(getCourse())
                .build();
    }
}
