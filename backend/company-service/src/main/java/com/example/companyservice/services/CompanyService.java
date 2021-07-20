package com.example.companyservice.services;

import com.example.companyservice.dtos.CompanyDto;
import com.example.companyservice.entities.BoardOfDirectors;
import com.example.companyservice.entities.Company;
import com.example.companyservice.entities.Sector;
import com.example.companyservice.mappers.CompanyMapper;
import com.example.companyservice.repositories.BoardOfDirectorsRepository;
import com.example.companyservice.repositories.CompanyRepository;
import com.example.companyservice.repositories.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private BoardOfDirectorsRepository boardOfDirectorsRepository;

    @Autowired
    private SectorRepository sectorRepository;

    @Autowired
    private CompanyMapper companyMapper;

    public List<CompanyDto> getAllCompanies(){
        List<Company> companies=companyRepository.findAll();
        if(companies.isEmpty()){
            return new ArrayList<>();
        }
        return companies.parallelStream().map(company -> companyMapper.map(company,CompanyDto.class)).collect(Collectors.toList());
    }
    public CompanyDto getCompany(int id){
        Optional<Company> company=companyRepository.findById(id);
        return company.map(value -> companyMapper.map(value, CompanyDto.class)).orElse(null);
    }

    public boolean addCompany(CompanyDto companyDto){
        Company company= companyMapper.map(companyDto,Company.class);
        Optional<Sector> sector=sectorRepository.findById(company.getSector().getId());
        if(!sector.isPresent()){
            return false;
        }
        companyRepository.save(company);
        for(BoardOfDirectors directors: company.getBoardOfDirectors()){
            directors.setCompany(company);
            boardOfDirectorsRepository.save(directors);
        }

        return true;
        
    }
    public boolean deleteCompany(int id){
        Optional<Company> company=companyRepository.findById(id);
        if(company.isPresent()) {
            for(BoardOfDirectors director:company.get().getBoardOfDirectors()){
                boardOfDirectorsRepository.delete(director);
            }
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
