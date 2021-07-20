package com.example.sectorservice.services;

import com.example.sectorservice.dtos.CompanyDto;
import com.example.sectorservice.dtos.SectorDto;
import com.example.sectorservice.entities.Company;
import com.example.sectorservice.entities.Sector;
import com.example.sectorservice.mappers.CompanyMapper;
import com.example.sectorservice.mappers.SectorMapper;
import com.example.sectorservice.repositories.CompanyRepository;
import com.example.sectorservice.repositories.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
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
    private CompanyMapper companyMapper;

    @Autowired
    private SectorMapper sectorMapper;

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



}
