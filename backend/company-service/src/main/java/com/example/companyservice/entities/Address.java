package com.example.companyservice.entities;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="address")
public class Address {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;

    private String building;

    private String street;

    private String city;

    private String district;

    private String state;

    private String country;

    private int pinCode;
    @OneToOne(mappedBy = "address")
    private StockExchange stockExchange;
}
