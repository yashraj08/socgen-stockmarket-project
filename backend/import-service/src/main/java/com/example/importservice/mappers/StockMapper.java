package com.example.importservice.mappers;

import com.example.importservice.Dtos.StockDto;
import com.example.importservice.entities.Stock;
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
