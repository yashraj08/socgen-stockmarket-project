package com.example.sectorservice.dtos;

import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Data
public class StockDto {
    private CompanyDto company;
    private StockExchangeDto stockExchange;
    private float currentPrice;
    private Date Date;
    private Time time;
}
