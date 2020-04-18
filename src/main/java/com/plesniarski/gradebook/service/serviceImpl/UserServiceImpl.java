package com.plesniarski.gradebook.service.serviceImpl;

import com.plesniarski.gradebook.domain.converter.Converter;
import com.plesniarski.gradebook.domain.dto.UserDto;
import com.plesniarski.gradebook.domain.entity.User;
import com.plesniarski.gradebook.domain.repository.UserRepository;
import com.plesniarski.gradebook.exceptions.UserNotFoundException;
import com.plesniarski.gradebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final Converter<UserDto, User> convertToEntity;
    private final Converter<User, UserDto> convertToDto;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           Converter<UserDto, User> convertToEntity,
                           Converter<User, UserDto> convertToDto) {
        this.userRepository = userRepository;
        this.convertToEntity = convertToEntity;
        this.convertToDto = convertToDto;
    }


    public User addUser(UserDto userDto){
        User user = convertToEntity.convert(userDto);
        return userRepository.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDto findUserById(long id) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(id);
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new).dto();
    }


}
