package com.example.importservice.repositories;

import com.example.importservice.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock,Integer> {
    List<Stock> findAllByStockExchangeId(int StockExchangeId);
}

