package com.example.authservice.dtos;

public class ResponseDto {
    private String accessToken;
    private String refreshToken;
    public ResponseDto(String accessToken,String refreshToken){
        this.accessToken=accessToken;
        this.refreshToken=refreshToken;
    }
}
