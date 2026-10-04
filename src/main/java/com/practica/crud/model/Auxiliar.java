package com.practica.crud.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "auxiliar")
public class Auxiliar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20, unique = true)
    private String codigo;

    @Column(nullable = false, length = 150)
    private String nombre;

    @Column(length = 255)
    private String descripcion;

    private Boolean activo = true;
}