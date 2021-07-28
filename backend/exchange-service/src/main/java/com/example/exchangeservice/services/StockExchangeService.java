package com.example.exchangeservice.services;

import com.example.exchangeservice.dtos.CompanyDto;
import com.example.exchangeservice.dtos.StockExchangeDto;
import com.example.exchangeservice.entities.Stock;
import com.example.exchangeservice.entities.StockExchange;
import com.example.exchangeservice.exceptions.EmptyInputException;
import com.example.exchangeservice.mappers.CompanyMapper;
import com.example.exchangeservice.mappers.StockExchangeMapper;
import com.example.exchangeservice.repositories.AddressRepository;
import com.example.exchangeservice.repositories.StockExchangeRepository;
import com.example.exchangeservice.repositories.StockRepository;
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
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private StockExchangeMapper stockExchangeMapper;
    @Autowired
    private CompanyMapper companyMapper;

    public List<StockExchangeDto> getAllStockExchange(){
            List<StockExchange> exchanges=stockExchangeRepository.findAll();
            if(exchanges.isEmpty()){
                throw new EmptyInputException("604","No stock exchange found");
            }
            return exchanges.parallelStream().map(stockExchange->stockExchangeMapper.map(stockExchange,StockExchangeDto.class)).collect(Collectors.toList());
    }
    public StockExchangeDto getStockExchange(int id){
             Optional<StockExchange> exchange=stockExchangeRepository.findById(id);
             if(!exchange.isPresent()) {
                 throw new EmptyInputException("604","Invalid Id");
             }
                 return stockExchangeMapper.map(exchange.get(),StockExchangeDto.class);

    }
    public boolean addStockExchange(StockExchangeDto stockExchangeDto){
          if(stockExchangeDto.getName()==null||stockExchangeDto.getAddress()==null)
              throw new EmptyInputException("604","name/address cannot be null");
        StockExchange stockExchange=stockExchangeMapper.map(stockExchangeDto,StockExchange.class);
          addressRepository.save(stockExchange.getAddress());
          stockExchangeRepository.save(stockExchange);
          return true;
    }

    public List<CompanyDto> getCompaniesOfStockExchange(int exchangeId){
        List<Stock> stocks=stockRepository.findAllByStockExchangeId(exchangeId);
        List<CompanyDto> companyDtos=new ArrayList<>();
        if(stocks.isEmpty())
            throw new EmptyInputException("604","Invalid ExchangeId");
        for(Stock stock:stocks){
            companyDtos.add(companyMapper.map(stock.getCompany(),CompanyDto.class));
        }
        return companyDtos;

    }


}
