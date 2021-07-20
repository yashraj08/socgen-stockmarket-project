package com.example.companyservice.services;

import com.example.companyservice.dtos.IpoDto;
import com.example.companyservice.entities.Ipo;
import com.example.companyservice.mappers.IpoMapper;
import com.example.companyservice.repositories.IpoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IpoServices {
    @Autowired
    private IpoRepository ipoRepository;
    @Autowired
    private IpoMapper ipoMapper;

    public List<IpoDto> getAllIpo(){
        List<Ipo> ipos=ipoRepository.findAll();
        return ipos.parallelStream().map(ipo->ipoMapper.map(ipo,IpoDto.class)).collect(Collectors.toList());
    }
    public IpoDto getIpo(int id){
        Optional<Ipo> ipo=ipoRepository.findById(id);
        return ipo.map(value->ipoMapper.map(value,IpoDto.class)).orElse(null);
    }
    public boolean addIpo(IpoDto ipoDto){
        ipoRepository.save(ipoMapper.map(ipoDto,Ipo.class));
        return true;
    }
    public boolean deleteIpo(int id){
        Optional<Ipo> ipo=ipoRepository.findById(id);
        if(ipo.isPresent()){
            ipoRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public IpoDto getIpoByCompanyId(int companyId){
        Optional<Ipo> ipo=ipoRepository.findByCompanyId(companyId);
        return ipo.map(value->ipoMapper.map(value,IpoDto.class)).orElse(null);
    }
}
