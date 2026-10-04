package com.practica.crud.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "est_ent")
public class EstadoEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clave;

    @Column(nullable = false, length = 30, unique = true)
    private String codigoEstado;

    @Column(nullable = false, length = 100)
    private String nombreEstado;

    @Column(length = 200)
    private String descripcion;

    private boolean vigente = true;
}