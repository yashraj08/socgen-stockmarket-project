package com.example.userservice.services;


import com.example.userservice.dtos.UserDto;
import com.example.userservice.entities.User;
import com.example.userservice.exceptions.EmptyInputException;
import com.example.userservice.mappers.UserMapper;
import com.example.userservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;


    public List<UserDto> getAllUser(){
        List<User> users = userRepository.findAll();
        if(users.isEmpty())
            throw new EmptyInputException("604","No User Found");
        return users.parallelStream().map(user->userMapper.map(user,UserDto.class)).collect(Collectors.toList());
    }

    public UserDto getUser(int id){
        Optional<User> userOptional=userRepository.findById(id);
        if(!userOptional.isPresent())
            throw new EmptyInputException("604","Invalid Id");
        return userOptional.map(value->userMapper.map(value,UserDto.class)).orElse(null);
    }

    public boolean addUser(UserDto userDto){
        if(userDto.getUsername()==null||userDto.getPassword()==null||userDto.getEmail()==null||userDto.getMobile()==null||userDto.getIsdCode()==null)
            throw new EmptyInputException("604","Invalid Input");
        User user=userMapper.map(userDto, User.class);
        user.setAdmin(false);
        user.setConfirmed(false);
        user.setPassword(BCrypt.hashpw(user.getPassword(),BCrypt.gensalt()));
        userRepository.save(user);
        return true;
    }

    public boolean deleteUser(int id){
        Optional<User> userOptional=userRepository.findById(id);
        if(!userOptional.isPresent()){
            throw new EmptyInputException("604","Invalid Id");
        }
            userRepository.deleteById(id);
            return true;

    }
    public boolean updateUser(int id, UserDto userDto){
        Optional<User> userOptional=userRepository.findById(id);
        if(!userOptional.isPresent()) {
            throw new EmptyInputException("604","Invalid Id");
        }
            userOptional.get().setUsername(userDto.getUsername());
            userOptional.get().setEmail(userDto.getEmail());
            userOptional.get().setIsdCode(userDto.getIsdCode());
            userOptional.get().setMobile(userDto.getMobile());

        return true;
    }





}
