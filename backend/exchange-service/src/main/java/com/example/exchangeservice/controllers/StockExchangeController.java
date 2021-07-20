package com.example.exchangeservice.controllers;


import com.example.exchangeservice.dtos.CompanyDto;
import com.example.exchangeservice.dtos.StockExchangeDto;
import com.example.exchangeservice.services.StockExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/stockExchange")
@RestController
public class StockExchangeController {
    @Autowired
    private StockExchangeService stockExchangeService;

    @GetMapping
    public List<StockExchangeDto> getAllStockExchange(){
        return stockExchangeService.getAllStockExchange();
    }
    @GetMapping("{id}")
    public StockExchangeDto getStockExchange(@PathVariable int id){
        return stockExchangeService.getStockExchange(id);

    }
    @PostMapping
    public boolean addStockExchange(@RequestBody StockExchangeDto stockExchangeDto){
        return stockExchangeService.addStockExchange(stockExchangeDto);
    }
    @GetMapping("{id}/company")
    public List<CompanyDto> getCompaniesOfStockExchange(@PathVariable int id){
        return stockExchangeService.getCompaniesOfStockExchange(id);
    }

}
