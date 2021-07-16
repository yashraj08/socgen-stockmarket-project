package com.example.exchangeservice.services;

import com.example.exchangeservice.dtos.AddressDto;
import com.example.exchangeservice.dtos.StockExchangeDto;
import com.example.exchangeservice.entities.StockExchange;
import com.example.exchangeservice.mappers.StockExchangeMapper;
import com.example.exchangeservice.repositories.AddressRepository;
import com.example.exchangeservice.repositories.StockExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StockExchangeService {

    @Autowired
    private StockExchangeRepository stockExchangeRepository;
    private AddressRepository addressRepository;
    private StockExchangeMapper stockExchangeMapper;


    public List<StockExchangeDto> getAllStockExchange(){
            List<StockExchange> li=stockExchangeRepository.findAll();
            if(li.isEmpty()){
                List<StockExchangeDto> emptyList=new ArrayList<>();
                return emptyList;
            }
            return li.parallelStream().map(stockExchange->stockExchangeMapper.map(stockExchange,StockExchangeDto.class)).collect(Collectors.toList());
    }
    public StockExchangeDto getStockExchange(int id){
             Optional<StockExchange> exchange=stockExchangeRepository.findById(id);
             if(exchange.isPresent()){
                 return stockExchangeMapper.map(exchange.get(),StockExchangeDto.class);
             }
             return null;
    }
    public boolean addStockExchange(StockExchangeDto stockExchangeDto){
          StockExchange stockExchange=stockExchangeMapper.map(stockExchangeDto,StockExchange.class);
          addressRepository.save(stockExchange.getAddress());
          stockExchangeRepository.save(stockExchange);
          return true;
    }


}
