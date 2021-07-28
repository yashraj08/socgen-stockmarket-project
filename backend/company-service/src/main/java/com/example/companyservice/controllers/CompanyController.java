package com.example.companyservice.controllers;


import com.example.companyservice.dtos.CompanyDto;
import com.example.companyservice.dtos.StockDto;
import com.example.companyservice.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/company")
@CrossOrigin
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

    @GetMapping("/search/{searchKey}")
    public List<CompanyDto> searchCompany(@PathVariable String searchKey){
        return companyService.searchCompany(searchKey);
    }
    @PostMapping("/{id}/price")
    public List<StockDto> companyPrice(@PathVariable int id, @RequestBody Date fromDate, @RequestBody Time fromTime, @RequestBody Date toDate, @RequestBody Time toTime){
        return companyService.companyPrices(id,fromDate,fromTime,toDate,toTime);
    }

}
