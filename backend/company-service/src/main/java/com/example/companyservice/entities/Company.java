package com.example.companyservice.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="Company")
public class Company {
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    private int id;

    private String name;

    private float turnover;

    private String ceo;

    private boolean listed;

    private String about;

    @OneToMany(mappedBy = "company")
    private List<BoardOfDirectors> boardOfDirectors= new ArrayList<>();

    @ManyToOne()
    @JoinColumn(name="sector_id",referencedColumnName ="id")
    private Sector sector;

    public void addBoardOfDirectors(BoardOfDirectors boardOfDirectors){
        this.boardOfDirectors.add(boardOfDirectors);
    }
    public void removeBoardOfDirectors(BoardOfDirectors boardOfDirectors){
        this.boardOfDirectors.remove(boardOfDirectors);
    }
}
