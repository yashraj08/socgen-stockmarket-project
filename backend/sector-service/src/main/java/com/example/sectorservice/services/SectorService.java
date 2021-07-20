package com.example.sectorservice.services;

import com.example.sectorservice.dtos.CompanyDto;
import com.example.sectorservice.dtos.SectorDto;
import com.example.sectorservice.dtos.StockDto;
import com.example.sectorservice.entities.Company;
import com.example.sectorservice.entities.Sector;
import com.example.sectorservice.entities.Stock;
import com.example.sectorservice.mappers.CompanyMapper;
import com.example.sectorservice.mappers.SectorMapper;
import com.example.sectorservice.mappers.StockMapper;
import com.example.sectorservice.repositories.CompanyRepository;
import com.example.sectorservice.repositories.SectorRepository;
import com.example.sectorservice.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Time;
import java.util.ArrayList;
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
            return new ArrayList<>();
        return sectors.parallelStream().map(sector->sectorMapper.map(sector,SectorDto.class)).collect(Collectors.toList());
    }

    public SectorDto getSector(int id){
        Optional<Sector>sector=sectorRepository.findById(id);
        return sector.map(value->sectorMapper.map(value,SectorDto.class)).orElse(null);

    }
    public List<CompanyDto> getCompaniesOfSector(int sectorId){
        Optional<Sector> sector= sectorRepository.findById(sectorId);
        if(sector.isPresent()){
            List<Company> companies=companyRepository.findAllBySectorId(sectorId);
            return companies.parallelStream().map(company->companyMapper.map(company,CompanyDto.class)).collect(Collectors.toList());
        }
        return new ArrayList<>();

    }
    public boolean addSector(SectorDto sectorDto){
        sectorRepository.save(sectorMapper.map(sectorDto,Sector.class));
        return true;
    }
    public List<StockDto> sectorPrices(int sectorId, Date fromDate, Time fromTime, Date toDate, Time toTime){
        List<Stock> stocks =stockRepository.findAllBySectorIdAndPeriod(sectorId,fromDate,toDate,fromTime,toTime);
        return stocks.parallelStream().map(stock->stockMapper.map(stock,StockDto.class)).collect(Collectors.toList());
    }
}
