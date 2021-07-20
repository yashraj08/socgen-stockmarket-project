package com.example.exchangeservice.repositories;

import com.example.exchangeservice.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock,Integer> {
    List<Stock> findAllByStockExchangeId(int StockExchangeId);
}

