package com.practica.crud.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "objgasto")
public class ObjetivoGasto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoRegistro;

    @Column(nullable = false, length = 30, unique = true)
    private String claveObjetivo;

    @Column(nullable = false, length = 120)
    private String descripcion;

    @Column(length = 100)
    private String categoria;

    private boolean vigente = true;
}