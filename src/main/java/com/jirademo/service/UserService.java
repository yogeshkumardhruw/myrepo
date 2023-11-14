package com.jirademo.service;

import com.jirademo.dto.UserDto;
import com.jirademo.entities.User;

import java.util.List;

public interface UserService {

    UserDto getUserById(long id);
    UserDto createUser(UserDto userDto);
    List<UserDto> getAllUser();

}
