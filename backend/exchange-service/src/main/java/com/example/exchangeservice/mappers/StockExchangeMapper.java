package com.example.exchangeservice.mappers;

import com.example.exchangeservice.dtos.StockExchangeDto;
import com.example.exchangeservice.entities.StockExchange;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class StockExchangeMapper extends ConfigurableMapper{

    @Override
    protected void configure(MapperFactory factory) {

        factory.registerClassMap(factory.classMap(StockExchange.class, StockExchangeDto.class).byDefault().toClassMap());
    }
}
