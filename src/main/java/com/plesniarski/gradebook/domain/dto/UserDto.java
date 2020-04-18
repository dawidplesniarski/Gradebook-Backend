package com.plesniarski.gradebook.domain.dto;

import com.plesniarski.gradebook.domain.entity.User;

import java.io.Serializable;

public class UserDto implements Serializable {
    private Long userId;
    private String name;
    private String lastName;
    private Long albumNo;

    public UserDto(){}

    public UserDto(Builder builder){
        userId = builder.userId;
        name = builder.name;
        lastName = builder.lastName;
        albumNo = builder.albumNo;
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

    public static final class Builder{
        private Long userId;
        private String name;
        private String lastName;
        private Long albumNo;

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

        public UserDto build(){
            return new UserDto(this);
        }

    }

}
