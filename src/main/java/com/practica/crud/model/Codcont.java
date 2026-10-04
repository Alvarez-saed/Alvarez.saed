package com.practica.crud.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "codigos_contables")
public class Codcont {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identificador;

    @Column(nullable = false, length = 30, unique = true)
    private String codigoCuenta;

    @Column(nullable = false, length = 150)
    private String nombreCuenta;

    @Column(length = 100)
    private String tipoCuenta;

    private Integer nivelJerarquico;

    @Column(nullable = false)
    private boolean vigente = true;
}