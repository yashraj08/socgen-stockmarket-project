package com.example.sectorservice.controllers;


import com.example.sectorservice.dtos.CompanyDto;
import com.example.sectorservice.dtos.SectorDto;
import com.example.sectorservice.services.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/sector")
@RestController
public class SectorController {
    @Autowired
    private SectorService sectorService;

    @GetMapping
    public List<SectorDto> getAllSectors(){

        return sectorService.getAllSectors();
    }
    @GetMapping("{id}")
    public SectorDto getSector(@PathVariable int id){
        return sectorService.getSector(id);
    }
    @GetMapping("{id}/company")
    public List<CompanyDto> getCompaniesOfSector(@PathVariable int id){
        return sectorService.getCompaniesOfSector(id);

    }
    @PostMapping
    public boolean addSector(@RequestBody SectorDto sectorDto){
        return sectorService.addSector(sectorDto);
    }

}
