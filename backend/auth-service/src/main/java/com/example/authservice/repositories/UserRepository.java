package com.example.authservice.repositories;

import com.example.authservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("Select u from User u where u.username=:username")
    Optional<User> findByUsername(@Param("username") String username);
}
