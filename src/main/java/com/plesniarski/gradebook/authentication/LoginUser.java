package com.plesniarski.gradebook.authentication;

public class LoginUser {
    private String login;
    private String password;

    public LoginUser(){}

    public LoginUser(Builder builder) {
        login = builder.login;
        password = builder.password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public static final class Builder{
        private String login;
        private String password;

        public Builder login(String login){
            this.login = login;
            return this;
        }
        public Builder password(String password){
            this.password = password;
            return this;
        }

        public LoginUser build(){
            return new LoginUser(this);
        }
    }
}
