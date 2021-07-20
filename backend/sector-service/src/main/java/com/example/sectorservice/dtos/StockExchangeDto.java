package com.example.sectorservice.dtos;

import lombok.Data;

@Data
public class StockExchangeDto {
    private String name;
    private String brief;
    private String remark;
    private AddressDto address;
}
