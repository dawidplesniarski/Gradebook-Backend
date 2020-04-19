package com.plesniarski.gradebook.domain.entity;

import javax.persistence.*;

@Entity
@Table(name="uczelnia")
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long universityId;
    private String universityName;

    public Long getUniversityId() {
        return universityId;
    }

    public String getUniversityName() {
        return universityName;
    }

    public University(){}

    public University(Builder builder){
        universityId = builder.universityId;
        universityName = builder.universityName;
    }

    public static final class Builder{
        private Long universityId;
        private String universityName;

        public Builder(){}

        public Builder id(Long universityId){
            this.universityId = universityId;
            return this;
        }
        public Builder universityName(String universityName){
            this.universityName = universityName;
            return this;
        }
        public University build(){
            return new University(this);
        }
    }
}
