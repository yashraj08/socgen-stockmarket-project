package com.example.companyservice.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class IpoDto {
    private CompanyDto company;
    private StockExchangeDto stockExchange;
    private String remarks;
    private float pricePerStock;
    private int totalStock;
    private Date OpenDateTime;
}
