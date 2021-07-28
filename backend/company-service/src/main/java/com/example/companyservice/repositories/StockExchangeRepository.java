package com.example.companyservice.repositories;

import com.example.companyservice.entities.StockExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockExchangeRepository extends JpaRepository<StockExchange,Integer> {
}
