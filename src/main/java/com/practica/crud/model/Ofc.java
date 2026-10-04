package com.practica.crud.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "oficina")
public class Ofc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(nullable = false, length = 30, unique = true)
    private String claveOficina;

    @Column(nullable = false, length = 120)
    private String nombreOficina;

    @Column(length = 200)
    private String direccion;

    @Column(length = 20)
    private String telefono;

    private boolean activo = true;
}