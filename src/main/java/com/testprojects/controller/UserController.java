package com.testprojects.controller;

import com.testprojects.entity.User;
import com.testprojects.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @GetMapping("/getUser")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    @PostMapping("/postUser")
    public User createUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }
    @GetMapping("/{userId}")
    public User getUser(@PathVariable Long userId){
        return userRepository.findById(userId).orElse(null);
    }
    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User newUser){
        Optional<User> user=userRepository.findById(userId);
        if(user.isPresent()){
             User foundUser=user.get();
             foundUser.setName(newUser.getName());
            foundUser.setPassword(newUser.getPassword());
             userRepository.save(foundUser);
             return foundUser;
        }else
            return null ;
    }
}