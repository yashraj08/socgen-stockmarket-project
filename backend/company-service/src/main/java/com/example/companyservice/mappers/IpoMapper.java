package com.example.companyservice.mappers;
import com.example.companyservice.dtos.IpoDto;
import com.example.companyservice.entities.Ipo;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class IpoMapper extends ConfigurableMapper {
    @Override
    protected void configure(MapperFactory factory) {
        factory.registerClassMap(factory.classMap(Ipo.class, IpoDto.class).byDefault().toClassMap());
    }
}
