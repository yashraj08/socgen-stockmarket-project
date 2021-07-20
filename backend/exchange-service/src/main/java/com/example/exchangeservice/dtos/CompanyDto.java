package com.example.exchangeservice.dtos;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CompanyDto {
    private String name;
    private float turnover;
    private String ceo;
    private boolean listed;
    private String about;
    private List<BoardOfDirectorsDto> boardOfDirectors= new ArrayList<>();
    private SectorDto sector;
}
