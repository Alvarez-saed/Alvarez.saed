package com.practica.crud.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "parametros_sistema")
public class Config {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clave;

    @Column(nullable = false, length = 50, unique = true)
    private String nombreParametro;

    @Column(nullable = false, length = 255)
    private String valorParametro;

    @Column(length = 200)
    private String detalle;

    private boolean activo = true;
}