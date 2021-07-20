package com.example.exchangeservice.repositories;

import com.example.exchangeservice.entities.StockExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockExchangeRepository extends JpaRepository<StockExchange,Integer> {


}
