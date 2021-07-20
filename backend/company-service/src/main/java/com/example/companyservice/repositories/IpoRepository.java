package com.example.companyservice.repositories;

import com.example.companyservice.entities.Ipo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IpoRepository extends JpaRepository<Ipo,Integer> {
    Optional<Ipo> findByCompanyId(int companyId);
}
