package com.example.companyservice.repositories;

import com.example.companyservice.entities.BoardOfDirectors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardOfDirectorsRepository extends JpaRepository<BoardOfDirectors,Integer> {
}
