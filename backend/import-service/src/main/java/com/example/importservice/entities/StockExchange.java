package com.example.importservice.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="stockExchange")
public class StockExchange {
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    @Column(name="id",length = 5)
    private int id;

    @Column(name="name",length = 20)
    private String name;

    @Column(name="remark",length = 50)
    private String remark;

    @Column(name="brief",length = 100)
    private String brief;

    @OneToOne
    @JoinColumn(name="addressId",referencedColumnName = "id")
    private Address address;
    
}
