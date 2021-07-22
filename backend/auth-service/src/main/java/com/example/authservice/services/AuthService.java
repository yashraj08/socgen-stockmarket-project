package com.example.authservice.services;

import com.example.authservice.dtos.ResponseDto;
import com.example.authservice.dtos.UserDto;
import com.example.authservice.entities.User;
import com.example.authservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtil jwtUtil;

    public ResponseDto login(UserDto userDto){
        Optional<User> user=userRepository.findByUsername(userDto.getUsername());
        if(user.isPresent()&&user.get().getPassword().equals(passwordEncoder.encode(userDto.getPassword()))){
            String accessToken=jwtUtil.generate(user.get(),"ACCESS");
            String refreshToken=jwtUtil.generate(user.get(),"REFRESH");
            return new ResponseDto(accessToken,refreshToken);
        }
        return null;
    }
}
