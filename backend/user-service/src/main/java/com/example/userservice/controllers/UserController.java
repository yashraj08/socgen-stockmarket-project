package com.example.userservice.controllers;
import com.example.userservice.dtos.UserDto;
import com.example.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDto> getAllUser(){
        return userService.getAllUser();
    }
    @PostMapping
    public boolean addUser(@RequestBody UserDto userDto){
        return userService.addUser(userDto);
    }
    @GetMapping("{id}")
    public UserDto getUser(@PathVariable int id){
        return userService.getUser(id);
    }
    @DeleteMapping("{id}")
    public boolean deleteUser(@PathVariable int id){
        return userService.deleteUser(id);
    }
    @PutMapping("{id}")
    public boolean updateUser(@PathVariable int id,@RequestBody UserDto userDto){
        return userService.updateUser(id,userDto);
    }
}
