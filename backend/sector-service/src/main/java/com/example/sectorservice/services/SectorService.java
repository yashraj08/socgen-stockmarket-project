package com.example.sectorservice.services;

import com.example.sectorservice.dtos.CompanyDto;
import com.example.sectorservice.dtos.SectorDto;
import com.example.sectorservice.dtos.StockDto;
import com.example.sectorservice.entities.Company;
import com.example.sectorservice.entities.Sector;
import com.example.sectorservice.entities.Stock;
import com.example.sectorservice.exceptions.EmptyInputException;
import com.example.sectorservice.mappers.CompanyMapper;
import com.example.sectorservice.mappers.SectorMapper;
import com.example.sectorservice.mappers.StockMapper;
import com.example.sectorservice.repositories.CompanyRepository;
import com.example.sectorservice.repositories.SectorRepository;
import com.example.sectorservice.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SectorService {
    @Autowired
    private SectorRepository sectorRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private SectorMapper sectorMapper;

    @Autowired
    private StockMapper stockMapper;

    public List<SectorDto> getAllSectors(){
        List<Sector> sectors =sectorRepository.findAll();
        if(sectors.isEmpty())
            throw new EmptyInputException("604","No Sectors Found");

        return sectors.parallelStream().map(sector->sectorMapper.map(sector,SectorDto.class)).collect(Collectors.toList());
    }

    public SectorDto getSector(int id){
        Optional<Sector>sector=sectorRepository.findById(id);
        if(!sector.isPresent())
            throw new EmptyInputException("604","Invalid Sector");

        return sector.map(value->sectorMapper.map(value,SectorDto.class)).orElse(null);

    }
    public List<CompanyDto> getCompaniesOfSector(int sectorId){
        Optional<Sector> sector= sectorRepository.findById(sectorId);
        if(sector.isPresent()){
            throw new EmptyInputException("604","Invalid sectorId");

        }
            List<Company> companies=companyRepository.findAllBySectorId(sectorId);
            return companies.parallelStream().map(company->companyMapper.map(company,CompanyDto.class)).collect(Collectors.toList());


    }
    public boolean addSector(SectorDto sectorDto){
        if(sectorDto.getName()==null)
            throw new EmptyInputException("604","Name cannot be Empty");
        sectorRepository.save(sectorMapper.map(sectorDto,Sector.class));
        return true;
    }
    public List<StockDto> sectorPrices(int sectorId, Date fromDate, Time fromTime, Date toDate, Time toTime){

        if(sectorId==0||fromDate==null||fromTime==null||toDate==null||toTime==null)
            throw new EmptyInputException("604","Invalid Inputs");
        List<Stock> stocks =stockRepository.findAllBySectorIdAndPeriod(sectorId,fromDate,toDate,fromTime,toTime);
        if(stocks.isEmpty())
            throw new EmptyInputException("604","Invalid Id");
        return stocks.parallelStream().map(stock->stockMapper.map(stock,StockDto.class)).collect(Collectors.toList());
    }
}
