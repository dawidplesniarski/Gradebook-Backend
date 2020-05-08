package com.plesniarski.gradebook.domain.dto;

public class CoursesDto {
    private Long id;
    private String course;

    public CoursesDto(){}

    public CoursesDto(Builder builder){
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
        public CoursesDto build(){
            return new CoursesDto(this);
        }
    }
}
