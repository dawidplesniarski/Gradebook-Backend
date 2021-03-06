package com.plesniarski.gradebook.domain.dto;

import java.time.LocalDateTime;

public class GradesDto {
    private Long id;
    private Double grade;
    private String subject;
    private LocalDateTime date;
    private Long studentId;

    public GradesDto(){}

    public GradesDto(Builder builder){
        id = builder.id;
        grade = builder.grade;
        date = builder.date;
        studentId = builder.studentId;
        subject = builder.subject;
    }

    public Long getId() {
        return id;
    }

    public Double getGrade() {
        return grade;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Long getStudentId() {
        return studentId;
    }

    public String getSubject() {
        return subject;
    }

    public static final class Builder{
        private Long id;
        private Double grade;
        private String subject;
        private LocalDateTime date;
        private Long studentId;

        public Builder id(Long id){
            this.id = id;
            return this;
        }
        public Builder subject(String subject){
            this.subject = subject;
            return this;
        }
        public Builder grade(Double grade){
            this.grade = grade;
            return this;
        }
        public Builder date(LocalDateTime date){
            this.date = date;
            return this;
        }
        public Builder studentId(Long studentId){
            this.studentId = studentId;
            return this;
        }
        public GradesDto build(){
            return new GradesDto(this);
        }
    }
    public GradesDto dto(){
        return new Builder()
                .id(getId())
                .grade(getGrade())
                .subject(getSubject())
                .date(getDate())
                .studentId(getStudentId())
                .build();
    }
}
