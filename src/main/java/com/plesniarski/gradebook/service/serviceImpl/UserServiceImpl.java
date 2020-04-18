package com.plesniarski.gradebook.service.serviceImpl;

import com.plesniarski.gradebook.domain.converter.Converter;
import com.plesniarski.gradebook.domain.dto.UserDto;
import com.plesniarski.gradebook.domain.entity.User;
import com.plesniarski.gradebook.domain.repository.UserRepository;
import com.plesniarski.gradebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final Converter<UserDto, User> convertToEntity;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, Converter<UserDto, User> convertToEntity) {
        this.userRepository = userRepository;
        this.convertToEntity = convertToEntity;
    }


    public User addUser(UserDto userDto){
        User user = convertToEntity.convert(userDto);
        return userRepository.save(user);
    }


    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

}
