package com.plesniarski.gradebook.service.serviceImpl;

import com.plesniarski.gradebook.domain.converter.Converter;
import com.plesniarski.gradebook.domain.dto.UniversityDto;
import com.plesniarski.gradebook.domain.dto.UserDto;
import com.plesniarski.gradebook.domain.dto.UserUniversityDto;
import com.plesniarski.gradebook.domain.entity.University;
import com.plesniarski.gradebook.domain.entity.User;
import com.plesniarski.gradebook.domain.repository.UniversityRepository;
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
    private final Converter<UserDto, User> convertUserToEntity;
    private final UniversityRepository universityRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           Converter<UserDto, User> convertToEntity, UniversityRepository universityRepository) {
        this.userRepository = userRepository;
        this.convertUserToEntity = convertToEntity;
        this.universityRepository = universityRepository;
    }


    public User addUser(UserDto userDto){
        User user = convertUserToEntity.convert(userDto);
        return userRepository.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserUniversityDto findUserById(long id) throws UserNotFoundException {
        UserDto user = userRepository.findById(id).orElseThrow(UserNotFoundException::new).dto();
        System.out.println("Univer id " + user.getUserId());
        Optional<University> university = universityRepository.findById(user.getUniversityId());
        return new UserUniversityDto.Builder()
                .userId(user.getUserId())
                .name(user.getName())
                .lastName(user.getLastName())
                .albumNo(user.getAlbumNo())
                .isAdmin(user.isAdmin())
                .universityName(university.get().getUniversityName())
                .build();
    }



}
