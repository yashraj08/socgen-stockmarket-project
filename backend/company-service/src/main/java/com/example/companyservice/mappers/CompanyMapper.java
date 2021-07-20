package com.example.companyservice.mappers;

import com.example.companyservice.dtos.CompanyDto;
import com.example.companyservice.entities.Company;
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
