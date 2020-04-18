package com.plesniarski.gradebook.service.serviceImpl;

import com.plesniarski.gradebook.domain.entity.User;
import com.plesniarski.gradebook.domain.repository.UserRepository;
import com.plesniarski.gradebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User addUser(User u){
        User user = new User.Builder()
                .name(u.getName())
                .lastName(u.getLastName())
                .albumNo(u.getAlbumNo())
                .build();
        return userRepository.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

}
