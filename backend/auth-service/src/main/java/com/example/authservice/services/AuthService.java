package com.example.authservice.services;

import com.example.authservice.dtos.UserDto;
import com.example.authservice.entities.User;
import com.example.authservice.exceptions.EmptyInputException;
import com.example.authservice.exceptions.IncorrectPasswordException;
import com.example.authservice.exceptions.UserNotFoundException;
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
        if(userDto.getUsername().equals("")||userDto.getPassword().equals("") )
            throw new EmptyInputException("604","Empty Username/Password");
        Optional<User> user=userRepository.findByUsername(userDto.getUsername());
        if(!user.isPresent()){
            throw new UserNotFoundException("602","Incorrect username");
        }
        boolean match=user.get().getPassword().equals(BCrypt.hashpw(userDto.getPassword(),user.get().getPassword()));
        if(!match){
            throw new IncorrectPasswordException("603","Incorrect Password Exception");
        }
        else
            return jwtUtil.generate(user.get());
    }
}
