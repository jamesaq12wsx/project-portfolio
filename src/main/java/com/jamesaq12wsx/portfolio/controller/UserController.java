package com.jamesaq12wsx.portfolio.controller;

import com.jamesaq12wsx.portfolio.model.Resume;
import com.jamesaq12wsx.portfolio.model.User;
import com.jamesaq12wsx.portfolio.service.UserService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/user")
@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return this.userService.getAllUser();
    }

    @GetMapping(path = "{username}")
    public Optional<User> getUserByUsername(@PathVariable("username") String username){
        return userService.getUserByUsername(username);
    }

    @PostMapping
    public User addUser(@RequestBody User user){
        return this.userService.addNewUser(user);
    }

    @PutMapping(path = "{id}")
    public User modifyUser(@PathVariable UUID id, User user){
        return userService.modifyUser(id, user);
    }
}
