package com.example.userservice.entities;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name="Users")
public class User {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name="id",length = 5)
    private int id;

    @Column(name = "username",length = 20)
    private String username;

    @Column(name="password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile",length = 10)
    @Size(min = 10,max=10)
    private String mobile;

    @Column(name = "isdCode",length = 10)
    private String isdCode;

    @Column(name = "usertype",length = 20)
    private String usertype;

    @Column(name = "confirmed")
    private boolean confirmed;

}
