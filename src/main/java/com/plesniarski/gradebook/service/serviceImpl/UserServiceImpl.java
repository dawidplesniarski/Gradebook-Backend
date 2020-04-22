package com.plesniarski.gradebook.service.serviceImpl;

import com.plesniarski.gradebook.authentication.LoggedUser;
import com.plesniarski.gradebook.authentication.LoginUser;
import com.plesniarski.gradebook.domain.converter.Converter;
import com.plesniarski.gradebook.domain.dto.AllUsersDto;
import com.plesniarski.gradebook.domain.dto.UserDto;
import com.plesniarski.gradebook.domain.dto.UserUniversityDto;
import com.plesniarski.gradebook.domain.entity.University;
import com.plesniarski.gradebook.domain.entity.User;
import com.plesniarski.gradebook.domain.repository.UniversityRepository;
import com.plesniarski.gradebook.domain.repository.UserRepository;
import com.plesniarski.gradebook.exceptions.UserNotFoundException;
import com.plesniarski.gradebook.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<AllUsersDto> findAllUsers() {
        return userRepository.findAll().stream().map(User::dtoWithoutPass).collect(Collectors.toList());
    }

    @Override
    public UserUniversityDto findUserById(long id) throws UserNotFoundException {
        UserDto user = userRepository.findById(id).orElseThrow(UserNotFoundException::new).dto();
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

    @Override
    public Boolean loginValidation(LoginUser loginUser){
        String login = loginUser.getLogin();
        String password = loginUser.getPassword();
        final User user = userRepository.findByLogin(login);
        if(user.getPassword().equals(password)){
            return true;
        }
        return false;
    }

    public AllUsersDto getLoggedUser(LoginUser loginUser){
        String login = loginUser.getLogin();
        final User user = userRepository.findByLogin(login);
        return user.dtoWithoutPass();
    }

    public LoggedUser loggedUser(LoginUser loginUser){
        String token;
        Long now = System.currentTimeMillis();

        if(loginValidation(loginUser)){
            token = Jwts.builder()
                    .setSubject(loginUser.getLogin())
                    .claim("roles","user")
                    .setIssuedAt(new Date(now))
                    .setExpiration(new Date(now + 20000))
                    .signWith(SignatureAlgorithm.HS512, loginUser.getPassword())
                    .compact();
            AllUsersDto user = getLoggedUser(loginUser);
            return new LoggedUser.Builder()
                    .token(token)
                    .id(user.getUserId())
                    .name(user.getName())
                    .lastName(user.getLastName())
                    .albumNo(user.getAlbumNo())
                    .admin(user.isAdmin())
                    .universityId(user.getUniversityId())
                    .login(user.getLogin())
                    .course(user.getCourse())
                    .build();
        }
        return null;
    }



}
