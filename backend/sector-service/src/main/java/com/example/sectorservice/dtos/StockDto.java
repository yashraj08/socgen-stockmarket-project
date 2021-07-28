package com.example.sectorservice.dtos;

import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Data
public class StockDto {
    private int companyId;
    private int stockExchangeId;
    private float currentPrice;
    private Date date;
    private Time time;
}
