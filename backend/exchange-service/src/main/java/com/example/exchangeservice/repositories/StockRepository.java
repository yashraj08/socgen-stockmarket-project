package com.example.exchangeservice.repositories;

import com.example.exchangeservice.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock,Integer> {
    @Query("SELECT s FROM Stock s where s.stockExchange.id=:stockExchangeId")
    List<Stock> findAllByStockExchangeId(@Param("stockExchangeId") int stockExchangeId);
}

