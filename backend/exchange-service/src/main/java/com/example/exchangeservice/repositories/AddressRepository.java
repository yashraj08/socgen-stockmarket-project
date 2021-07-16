package com.example.exchangeservice.repositories;

import com.example.exchangeservice.repositories.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AddressRepository extends JpaRepository<Address,Integer> {
}
