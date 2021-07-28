package com.example.companyservice.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class IpoDto {
    private int companyId;
    private int stockExchangeId;
    private String remarks;
    private float pricePerStock;
    private int totalStock;
    private Date OpenDateTime;
}
