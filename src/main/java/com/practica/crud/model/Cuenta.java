package com.practica.crud.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cta_par")
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(nullable = false, length = 30, unique = true)
    private String numero;

    @Column(nullable = false, length = 150)
    private String nombre;

    @Column(length = 100)
    private String categoria;

    private boolean vigente = true;
}