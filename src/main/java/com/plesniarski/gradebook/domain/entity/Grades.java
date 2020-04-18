package com.plesniarski.gradebook.domain.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "grades")
public class Grades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double grade;
    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE NOT NULL")
    LocalDateTime date;

    public Grades(){}

    public Grades(Builder builder){
        id = builder.id;
        grade = builder.grade;
        date = builder.date;
    }


    public static final class Builder{
        private long id;
        private double grade;
        private LocalDateTime date;

        public Builder id(long id){
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

        public Grades build(){
            return new Grades(this);
        }

    }


}
