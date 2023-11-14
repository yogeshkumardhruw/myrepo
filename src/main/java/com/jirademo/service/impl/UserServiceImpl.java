package com.jirademo.service.impl;

import com.jirademo.dto.UserDto;
import com.jirademo.entities.Task;
import com.jirademo.entities.User;
import com.jirademo.exception.ResourceNotFoundException;
import com.jirademo.repositories.UserRepository;
import com.jirademo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto getUserById(long id){
//        User user = userRepository.findById(id).get();
//        return entityToDto(user);

        return userRepository.findById(id).map(u->entityToDto(u)).orElseThrow(()->new ResourceNotFoundException("User with given id is not found: "+id));
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = dtoToEntity(userDto);
        User save = userRepository.save(user);
        return entityToDto(save);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> all = userRepository.findAll();
        List<UserDto> collect = all.stream().map(u -> entityToDto(u)).collect(Collectors.toList());
        return collect;
    }

    public User dtoToEntity(UserDto userDto){
        return modelMapper.map(userDto, User.class);
    }

    public UserDto entityToDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }
}
