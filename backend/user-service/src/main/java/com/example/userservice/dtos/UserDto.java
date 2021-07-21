package com.example.userservice.dtos;

import lombok.Data;

@Data
public class UserDto {
    private String username;
    private String password;
    private String email;
    private String mobile;
    private String isdCode;
    private String type;
    private boolean confirmed;
}
