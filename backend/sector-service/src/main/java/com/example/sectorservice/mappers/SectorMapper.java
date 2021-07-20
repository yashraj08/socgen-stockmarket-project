package com.example.sectorservice.mappers;


import com.example.sectorservice.dtos.SectorDto;
import com.example.sectorservice.entities.Sector;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class SectorMapper extends ConfigurableMapper{

    @Override
    protected void configure(MapperFactory factory) {

        factory.registerClassMap(factory.classMap(Sector.class, SectorDto.class).byDefault().toClassMap());
    }
}
