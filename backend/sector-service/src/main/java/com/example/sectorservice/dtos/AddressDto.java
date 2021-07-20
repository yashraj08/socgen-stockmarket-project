package com.example.sectorservice.dtos;

import lombok.Data;

@Data
public class AddressDto {
    private String street;
    private String building;
    private String city;
    private String district;
    private String state;
    private String country;
    private int pinCode;
}
