package com.example.sectorservice.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Data
@Entity
@Table(name="stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",length = 5)
    private int id;

    @Column(name="currentPrice",length = 8)
    private float currentPrice;

    @Column(name="date")
    private Date date;

    @Column(name="time")
    private Time time;

    @OneToOne
    @JoinColumn(name="companyId",referencedColumnName = "id")
    private Company company;

    @ManyToOne
    @JoinColumn(name="stockExchangeId",referencedColumnName = "id")
    private StockExchange stockExchange;

}
