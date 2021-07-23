package com.example.authservice.services;

import com.example.authservice.dtos.UserDto;
import com.example.authservice.entities.User;
import com.example.authservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtil jwtUtil;

    public String login(UserDto userDto){
        Optional<User> user=userRepository.findByUsername(userDto.getUsername());
        if(user.isPresent() && user.get().getPassword().equals(BCrypt.hashpw(userDto.getPassword(),user.get().getPassword()))){
            return jwtUtil.generate(user.get());
        }
        return null;
    }
}
