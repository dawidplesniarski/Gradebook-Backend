package com.plesniarski.gradebook.service;

import com.plesniarski.gradebook.domain.dto.UserDto;
import com.plesniarski.gradebook.domain.entity.User;

import java.util.List;

public interface UserService {
    User addUser(UserDto userDto);
    List<User> findAllUsers();
}
