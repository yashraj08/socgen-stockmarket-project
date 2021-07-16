package com.example.exchangeservice.repositories;

import com.example.exchangeservice.repositories.entities.StockExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockExchangeRepository extends JpaRepository<StockExchange,Integer> {


}
