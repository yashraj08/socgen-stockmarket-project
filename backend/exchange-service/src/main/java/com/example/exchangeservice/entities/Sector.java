package com.example.exchangeservice.entities;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="Sector")
public class Sector {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id", length = 5)
    private int id;
    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "brief", length = 100)
    private String brief;
}

