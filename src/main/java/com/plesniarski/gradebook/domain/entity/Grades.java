package com.plesniarski.gradebook.domain.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "grades")
public class Grades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double grade;
    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE NOT NULL")
    LocalDateTime date;
    private Long studentId;

    public Grades(){}

    public long getId() {
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

    public Grades(Builder builder){
        id = builder.id;
        grade = builder.grade;
        date = builder.date;
        studentId = builder.studentId;
    }


    public static final class Builder{
        private Long id;
        private double grade;
        private LocalDateTime date;
        private Long studentId;

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder grade(double grade){
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

        public Grades build(){
            return new Grades(this);
        }

    }


}
