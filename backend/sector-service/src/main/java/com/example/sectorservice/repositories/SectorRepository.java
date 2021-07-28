package com.example.sectorservice.repositories;

import com.example.sectorservice.entities.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectorRepository extends JpaRepository<Sector,Integer> {
}
