package com.plesniarski.gradebook.domain.entity;

import com.plesniarski.gradebook.domain.dto.AllUsersDto;
import com.plesniarski.gradebook.domain.dto.UserDto;
import com.sun.istack.NotNull;
import javax.persistence.*;

@Entity
@Table(name = "student_tok")
public class User {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;
    private String lastName;
    private String albumNo;
    private Boolean admin;
    private Long universityId;
    private String login;
    private String password;
    private Long courseId;

    public User(){}

    public User(Builder builder){
        userId = builder.userId;
        name = builder.name;
        lastName = builder.lastName;
        albumNo = builder.albumNo;
        admin = builder.admin;
        universityId = builder.universityId;
        login = builder.login;
        password = builder.password;
        courseId = builder.courseId;
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

    public String getAlbumNo() {
        return albumNo;
    }

    public Boolean isAdmin() {
        return admin;
    }

    public Long getUniversityId(){
        return universityId;
    }
    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }

    public Long getCourseId() {
        return courseId;
    }

    public static final class Builder{
        private Long userId;
        private String name;
        private String lastName;
        private String albumNo;
        private Boolean admin;
        private Long universityId;
        private String login;
        private String password;
        private Long courseId;

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

        public Builder albumNo(String albumNo){
            this.albumNo = albumNo;
            return this;
        }
        public Builder admin(boolean admin){
            this.admin = admin;
            return this;
        }
        public Builder universityId(Long universityId){
            this.universityId = universityId;
            return this;
        }
        public Builder login(String login){
            this.login = login;
            return this;
        }
        public Builder password(String password){
            this.password = password;
            return this;
        }
        public Builder course(Long courseId){
            this.courseId = courseId;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }

    public UserDto dto(){
        return new UserDto.Builder()
                .id(getUserId())
                .name(getName())
                .lastName(getLastName())
                .albumNo(getAlbumNo())
                .universityId(getUniversityId())
                .course(getCourseId())
                .build();
    }
    public AllUsersDto dtoWithoutPass(){
        return new AllUsersDto.Builder()
                .id(getUserId())
                .name(getName())
                .lastName(getLastName())
                .albumNo(getAlbumNo())
                .admin(isAdmin())
                .universityId(getUniversityId())
                .course(getCourseId())
                .login(getLogin())
                .build();

    }

}
