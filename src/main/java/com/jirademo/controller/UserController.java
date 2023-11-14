package com.jirademo.controller;

import com.jirademo.dto.UserDto;
import com.jirademo.entities.User;
import com.jirademo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable long id){
        return userService.getUserById(id);
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto){
        return userService.createUser(userDto);
    }

    @GetMapping("/")
    public List<UserDto> getAllUser(){
        return userService.getAllUser();
    }

}
