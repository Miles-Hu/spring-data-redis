/*
package com.miles.springdataredis.controller;

import com.miles.springdataredis.model.User;
import com.miles.springdataredis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequestMapping("/rest/user")
public class UserController {

    @Autowired
    private UserService userRepository;

    @PostMapping("/{id}")
    public User add(@PathVariable String id,
                    @RequestParam String name,
                    @RequestParam String sex,
                    @RequestParam String nation){
        return userRepository.save(
                new User(id,name,sex,nation, Instant.now().getEpochSecond())
        );
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable String id){
        return userRepository.findById(id);
    }


    @PutMapping("/{id}")
    public User updateUserById(@PathVariable String id,
        @RequestParam String name, @RequestParam String sex,
        @RequestParam String nation){

        return userRepository.update(
                new User(id,name,sex,nation,Instant.now().getEpochSecond())
        );
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable String id){
        userRepository.delete(id);
    }
}
*/
