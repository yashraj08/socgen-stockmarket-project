package com.example.authservice.dtos;

import lombok.Data;

@Data
public class ResponseDto {
    private String accessToken;
    private String refreshToken;
}
