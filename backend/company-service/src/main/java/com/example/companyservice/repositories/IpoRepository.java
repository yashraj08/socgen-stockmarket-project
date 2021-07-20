package com.example.companyservice.repositories;

import com.example.companyservice.entities.Ipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface IpoRepository extends JpaRepository<Ipo,Integer> {
    @Query("SELECT i FROM Ipo i Where i.company.id = :companyId"  )
    Optional<Ipo> findByCompanyId(@Param("companyId") int companyId);
}
