package com.example.companyservice.controllers;


import com.example.companyservice.dtos.CompanyDto;
import com.example.companyservice.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/company")
@RestController
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping
    public List<CompanyDto> getAllCompanies(){

        return companyService.getAllCompanies();
    }
    @GetMapping("{id}")
    public CompanyDto getCompany(@PathVariable int id){
        return companyService.getCompany(id);

    }
    @PostMapping
    public boolean addCompany(@RequestBody CompanyDto companyDto){
        return companyService.addCompany(companyDto);
    }
    @DeleteMapping("{id}")
    public boolean deleteCompany(@PathVariable int id){
        return companyService.deleteCompany(id);
    }

}
