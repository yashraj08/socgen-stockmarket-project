package com.example.companyservice.controllers;

import com.example.companyservice.dtos.IpoDto;
import com.example.companyservice.services.IpoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/ipo")
@CrossOrigin
public class IpoController {
    @Autowired
    private IpoServices ipoServices;

    @GetMapping
    public List<IpoDto> getAllIpo(){
        return ipoServices.getAllIpo();
    }

    @GetMapping("{id}")
    public IpoDto getIpo(@PathVariable int id){
        return ipoServices.getIpo(id);
    }

    @PostMapping
    public boolean addIpo(@RequestBody IpoDto ipoDto){
        return ipoServices.addIpo(ipoDto);
    }

    @DeleteMapping("{id}")
    public boolean deleteIpo(@PathVariable int id){
        return ipoServices.deleteIpo(id);
    }

    @GetMapping("/company/{id}")
    public IpoDto getIpoByCompanyId(@PathVariable int id){
        return ipoServices.getIpoByCompanyId(id);
    }


}
