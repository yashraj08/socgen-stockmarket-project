package com.example.importservice.entities;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="address")
public class Address {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name="id",length = 5)
    private int id;

    @Column(name="building",length = 20)
    private String building;

    @Column(name="street",length = 20)
    private String street;

    @Column(name="city",length = 20)
    private String city;

    @Column(name="district",length = 20)
    private String district;

    @Column(name="state",length = 20)
    private String state;

    @Column(name="country",length = 20)
    private String country;

    @Column(name="pinCode",length = 5)
    private int pinCode;
    @OneToOne(mappedBy = "address")
    private StockExchange stockExchange;
}
