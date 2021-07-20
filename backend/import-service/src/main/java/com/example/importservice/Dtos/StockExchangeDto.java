package com.example.importservice.Dtos;

import lombok.Data;

@Data
public class StockExchangeDto {
    private String name;
    private String brief;
    private String remark;
    private AddressDto address;
}
