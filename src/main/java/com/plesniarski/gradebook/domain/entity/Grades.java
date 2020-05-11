package com.plesniarski.gradebook.domain.entity;

import com.plesniarski.gradebook.domain.dto.GradesDto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "grades")
public class Grades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double grade;
    private String subject;
    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE NOT NULL")
    LocalDateTime date;
    private Long studentId;

    public Grades(){}

    public Grades(Builder builder){
        id = builder.id;
        subject = builder.subject;
        grade = builder.grade;
        date = builder.date;
        studentId = builder.studentId;
    }

    public Long getId() {
        return id;
    }

    public double getGrade() {
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

        public Builder date(LocalDateTime now){
            this.date = now;
            return this;
        }
        public Builder studentId(Long studentId){
            this.studentId = studentId;
            return this;
        }

        public Grades build(){
            return new Grades(this);
        }

    }

    public GradesDto dto(){
        return new GradesDto.Builder().id(getId()).subject(getSubject()).grade(getGrade()).date(getDate()).studentId(getStudentId()).build();
    }


}
