package com.example.importservice.entities;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name="boardOfDirectors")
public class BoardOfDirectors {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name="id",length=5)
    private int id;

    @Column(name="name",length=20)
    private String name;

    @ManyToOne
    @JoinColumn(name="companyId",referencedColumnName = "id")
    private Company company;
}


