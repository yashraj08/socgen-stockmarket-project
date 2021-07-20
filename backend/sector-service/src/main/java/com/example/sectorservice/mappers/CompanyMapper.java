package com.example.sectorservice.mappers;

import com.example.sectorservice.dtos.CompanyDto;
import com.example.sectorservice.entities.Company;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper extends ConfigurableMapper{

    @Override
    protected void configure(MapperFactory factory) {

        factory.registerClassMap(factory.classMap(Company.class, CompanyDto.class).byDefault().toClassMap());
    }
}
