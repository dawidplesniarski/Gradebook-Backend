package com.plesniarski.gradebook.controller;

import com.plesniarski.gradebook.authentication.LoggedUser;
import com.plesniarski.gradebook.authentication.LoginUser;
import com.plesniarski.gradebook.domain.dto.AllUsersDto;
import com.plesniarski.gradebook.domain.dto.UserDto;
import com.plesniarski.gradebook.domain.dto.UserUniversityDto;
import com.plesniarski.gradebook.domain.entity.User;
import com.plesniarski.gradebook.exceptions.LoginOrPasswordIncorrectException;
import com.plesniarski.gradebook.exceptions.UserNotFoundException;
import com.plesniarski.gradebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin
    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody UserDto user){
        final User u = userService.addUser(user);
        return ResponseEntity.status(201).body(u);
    }

    @CrossOrigin
    @GetMapping("/findAll")
    public ResponseEntity<List<AllUsersDto>> findAllUsers(){
        final List<AllUsersDto> users = userService.findAllUsers();
        return ResponseEntity.ok(users);
    }

    @CrossOrigin
    @GetMapping("/findUser/{id}")
    public ResponseEntity<UserUniversityDto> getUserById(@PathVariable Long id) throws UserNotFoundException {
        final UserUniversityDto user = userService.findUserById(id);
        return ResponseEntity.ok(user);
    }

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<LoggedUser> login(@RequestBody LoginUser loginUser) {
            LoggedUser loggedUserOptional = userService.loggedUser(loginUser);
            if(loggedUserOptional == null) {
                return ResponseEntity.status(401).body(null);
            }
            return ResponseEntity.ok(loggedUserOptional);
    }

    @CrossOrigin
    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUserById(id);
    }

    @CrossOrigin
    @GetMapping("/findByUniversity/{id}")
    public ResponseEntity<List<AllUsersDto>> findUsersByUniversityId(@PathVariable Long id){
        return ResponseEntity.ok(userService.findUsersByUniversityId(id));
    }
}
