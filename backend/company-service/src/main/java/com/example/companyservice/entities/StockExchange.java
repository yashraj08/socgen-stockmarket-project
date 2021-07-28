package com.example.companyservice.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="stockExchange")
public class StockExchange {
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    private int id;

    private String name;

    private String remark;

    private String brief;

    @OneToOne
    @JoinColumn(name="addressId",referencedColumnName = "id")
    private Address address;

}
