package com.plesniarski.gradebook.service;

import com.plesniarski.gradebook.domain.dto.UserDto;
import com.plesniarski.gradebook.domain.entity.User;
import com.plesniarski.gradebook.exceptions.UserNotFoundException;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User addUser(UserDto userDto);
    List<User> findAllUsers();
    UserDto findUserById(long id) throws UserNotFoundException;
}
