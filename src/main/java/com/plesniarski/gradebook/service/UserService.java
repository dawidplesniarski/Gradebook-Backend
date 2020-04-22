package com.plesniarski.gradebook.service;

import com.plesniarski.gradebook.authentication.LoginUser;
import com.plesniarski.gradebook.domain.dto.AllUsersDto;
import com.plesniarski.gradebook.domain.dto.UserDto;
import com.plesniarski.gradebook.domain.dto.UserUniversityDto;
import com.plesniarski.gradebook.domain.entity.User;
import com.plesniarski.gradebook.exceptions.UserNotFoundException;

import java.util.List;

public interface UserService {
    User addUser(UserDto userDto);
    List<AllUsersDto> findAllUsers();
    UserUniversityDto findUserById(long id) throws UserNotFoundException;
    Boolean loginValidation(LoginUser loginUser);
    AllUsersDto getLoggedUser(LoginUser loginUser);
    }
