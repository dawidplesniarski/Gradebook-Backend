package com.plesniarski.gradebook.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;
    private String lastName;
    private Long albumNo;

    public User(){}

    public User(Builder builder){
        userId = builder.userId;
        name = builder.name;
        lastName = builder.lastName;
        albumNo = builder.albumNo;
    }

    public static final class Builder{
        private Long userId;
        private String name;
        private String lastName;
        private Long albumNo;

        public Builder(){}

        public Builder id(Long userId){
            this.userId = userId;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Builder albumNo(Long albumNo){
            this.albumNo = albumNo;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }

}
