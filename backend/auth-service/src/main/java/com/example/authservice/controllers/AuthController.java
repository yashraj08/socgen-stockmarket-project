package com.example.authservice.controllers;

import com.example.authservice.dtos.UserDto;
import com.example.authservice.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDto userDto){
        return ResponseEntity.ok(authService.login(userDto));
    }
}
