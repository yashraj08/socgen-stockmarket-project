package com.example.companyservice.services;

import com.example.companyservice.dtos.IpoDto;
import com.example.companyservice.entities.Company;
import com.example.companyservice.entities.Ipo;
import com.example.companyservice.entities.StockExchange;
import com.example.companyservice.mappers.IpoMapper;
import com.example.companyservice.repositories.CompanyRepository;
import com.example.companyservice.repositories.IpoRepository;
import com.example.companyservice.repositories.StockExchangeRepository;
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
    private CompanyRepository companyRepository;
    @Autowired
    private StockExchangeRepository stockExchangeRepository;
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
    public boolean addIpo(IpoDto ipoDto) {
        Optional<Company> company = companyRepository.findById(ipoDto.getCompanyId());
        if (!company.isPresent()) {
            return false;
        }
        Optional<StockExchange> exchange = stockExchangeRepository.findById(ipoDto.getStockExchangeId());
        if (!exchange.isPresent()){
            return false;
        }
        Ipo ipo=ipoMapper.map(ipoDto,Ipo.class);
        ipo.setCompany(company.get());
        ipo.setStockExchange(exchange.get());
        ipoRepository.save(ipo);
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
