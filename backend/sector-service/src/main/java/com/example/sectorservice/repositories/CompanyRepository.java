package com.example.sectorservice.repositories;

import com.example.sectorservice.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer> {
   List<Company> findAllBySectorId(int SectorId);
}
