package com.example.importservice.Mapper;

import com.example.importservice.Dtos.StockDto;
import com.example.importservice.entities.Stock;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

public class StockMapper extends ConfigurableMapper {
    @Override
    protected void configure(MapperFactory factory) {
        factory.registerClassMap(factory.classMap(Stock.class, StockDto.class).byDefault().toClassMap());
    }
}
