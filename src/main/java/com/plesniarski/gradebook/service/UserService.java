package com.plesniarski.gradebook.service;

import com.plesniarski.gradebook.domain.dto.UserDto;
import com.plesniarski.gradebook.domain.dto.UserUniversityDto;
import com.plesniarski.gradebook.domain.entity.User;
import com.plesniarski.gradebook.exceptions.UserNotFoundException;

import java.util.List;

public interface UserService {
    User addUser(UserDto userDto);
    List<User> findAllUsers();
    UserUniversityDto findUserById(long id) throws UserNotFoundException;
}
