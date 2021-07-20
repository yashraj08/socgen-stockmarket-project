package com.example.sectorservice.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="company")
public class Company {
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    @Column(name="id",length=5)
    private int id;

    @Column(name="name",length=50)
    private String name;

    @Column(name="turnover",length=8)
    private float turnover;

    @Column(name="ceo",length=20)
    private String ceo;

    @Column(name="listed")
    private boolean listed;

    @Column(name="about",length=100)
    private String about;

    @OneToMany(mappedBy = "company")
    private List<BoardOfDirectors> boardOfDirectors= new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="sectorId",referencedColumnName ="id")
    private Sector sector;

}
