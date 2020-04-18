package com.plesniarski.gradebook.domain.entity;

import com.plesniarski.gradebook.domain.dto.UserDto;
import com.sun.istack.NotNull;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "studenciak")
public class User {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;
    private String lastName;
    private Long albumNo;
    private Boolean admin;

    public User(){}

    public User(Builder builder){
        userId = builder.userId;
        name = builder.name;
        lastName = builder.lastName;
        albumNo = builder.albumNo;
        admin = builder.admin;
    }

    public Long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Long getAlbumNo() {
        return albumNo;
    }

    public Boolean isAdmin() {
        return admin;
    }

    public static final class Builder{
        private Long userId;
        private String name;
        private String lastName;
        private Long albumNo;
        private Boolean admin;

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
        public Builder admin(boolean admin){
            this.admin = admin;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }

    public UserDto dto(){
        return new UserDto.Builder().id(getUserId()).name(getName()).lastName(getLastName()).albumNo(getAlbumNo()).build();
    }

}
