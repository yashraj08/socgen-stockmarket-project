package com.example.sectorservice.repositories;

import com.example.sectorservice.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer> {
   @Query("SELECT c FROM Company c WHERE c.sector.id=:sectorId")
   List<Company> findAllBySectorId(@Param("sectorId") int sectorId);
}
