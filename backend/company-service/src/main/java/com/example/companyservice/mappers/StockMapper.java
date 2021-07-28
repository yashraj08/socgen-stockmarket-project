package com.example.companyservice.mappers;

import com.example.companyservice.dtos.StockDto;
import com.example.companyservice.entities.Stock;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class StockMapper extends ConfigurableMapper {
    @Override
    protected void configure(MapperFactory factory) {
        factory.registerClassMap(factory.classMap(Stock.class, StockDto.class).byDefault().toClassMap());
    }
}