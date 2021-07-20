package com.example.companyservice.entities;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="Sector")
public class Sector {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    private String name;
    private String brief;

}

