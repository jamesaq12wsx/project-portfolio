package com.jamesaq12wsx.portfolio.service;

import com.jamesaq12wsx.portfolio.model.User;
import com.jamesaq12wsx.portfolio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(UUID id){
        return userRepository.findById(id);
    }

    public Optional<User> getUserByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public User addNewUser(User user){
        return userRepository.save(user);
    }

    public User modifyUser(UUID id, User user){

        User targetUser = userRepository.findById(id).orElse(null);

        if (targetUser == null){
            return null;
        }

        user.setId(targetUser.getId());

        return userRepository.save(user);
    }

    public boolean deleteUserById(UUID id){
        try{
            userRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
