package com.plesniarski.gradebook.service;

import com.plesniarski.gradebook.domain.entity.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    List<User> findAllUsers();
}
