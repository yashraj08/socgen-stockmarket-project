package com.example.sectorservice.repositories;

import com.example.sectorservice.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface StockRepository extends JpaRepository<Stock,Integer> {
    @Query("SELECT s FROM Stock s WHERE s.company.sector.id=:sectorId AND s.date BETWEEN :fromDate AND :toDate and s.time BETWEEN :fromTime AND :toTime")
    List<Stock> findAllBySectorIdAndPeriod(@Param("sectorId")int sectorId, @Param("fromDate") Date fromDate, @Param("toDate")Date toDate, @Param("fromTime") Time fromTime, @Param("toTime") Time toTime);

}
