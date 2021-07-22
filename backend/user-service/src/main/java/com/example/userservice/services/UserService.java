package com.example.userservice.services;


import com.example.userservice.dtos.UserDto;
import com.example.userservice.entities.User;
import com.example.userservice.mappers.UserMapper;
import com.example.userservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;
    @Autowired
    PasswordEncoder passwordEncoder;

    public List<UserDto> getAllUser(){
        List<User> users = userRepository.findAll();
        if(users.isEmpty())
            return new ArrayList<>();
        return users.parallelStream().map(user->userMapper.map(user,UserDto.class)).collect(Collectors.toList());
    }

    public UserDto getUser(int id){
        Optional<User> userOptional=userRepository.findById(id);
        return userOptional.map(value->userMapper.map(value,UserDto.class)).orElse(null);
    }

    public boolean addUser(UserDto userDto){
        User user=userMapper.map(userDto, User.class);
        user.setAdmin(false);
        user.setConfirmed(false);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

    public boolean deleteUser(int id){
        Optional<User> userOptional=userRepository.findById(id);
        if(userOptional.isPresent()){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public boolean updateUser(int id, UserDto userDto){
        Optional<User> userOptional=userRepository.findById(id);
        if(userOptional.isPresent()){
            userOptional.get().setUsername(userDto.getUsername());
            userOptional.get().setEmail(userDto.getEmail());
            userOptional.get().setIsdCode(userDto.getIsdCode());
            userOptional.get().setMobile(userDto.getMobile());
        }
        return false;
    }





}
