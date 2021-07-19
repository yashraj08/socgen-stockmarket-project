package com.example.companyservice.entities;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="BoardOfDirectors")
public class BoardOfDirectors {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;

    private String Name;

    @ManyToOne
    @JoinColumn(name="company_id",referencedColumnName = "id")
    private Company company;
}
