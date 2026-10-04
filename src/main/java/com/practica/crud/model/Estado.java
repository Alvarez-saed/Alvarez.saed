package com.practica.crud.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "estado")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identificador;

    @Column(nullable = false, length = 30, unique = true)
    private String claveEstado;

    @Column(nullable = false, length = 100)
    private String nombreEstado;

    @Column(length = 200)
    private String detalle;

    private boolean activo = true;
}