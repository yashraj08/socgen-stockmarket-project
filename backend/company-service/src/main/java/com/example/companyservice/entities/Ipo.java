package com.example.companyservice.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="ipo")
public class Ipo {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name="id",length = 5)
    private int id;

    @OneToOne
    @JoinColumn(name="companyId",referencedColumnName = "id")

    private Company company;

    @Column(name="remarks",length = 50)
    private String remarks;

    @Column(name="pricePerStock",length = 8)
    private float pricePerStock;

    @Column(name="totalStocks",length=5)
    private int totalStocks;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="openDateTime")
    private Date openDateTime;

    @ManyToOne
    @JoinColumn(name="stockExchangeId",referencedColumnName = "id")
    private StockExchange stockExchange;

}
