package com.example.userservice.mappers;


import com.example.userservice.dtos.UserDto;
import com.example.userservice.entities.User;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends ConfigurableMapper {
    @Override
    protected void configure(MapperFactory factory) {
        factory.registerClassMap(factory.classMap(User.class, UserDto.class).byDefault().toClassMap());
    }
}
