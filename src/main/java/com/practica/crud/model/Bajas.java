package com.practica.crud.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "bajas")
public class Bajas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoRegistro;

    @Column(nullable = false, length = 30, unique = true)
    private String numeroBaja;

    @Column(nullable = false, length = 120)
    private String descripcionElemento;

    @Column(length = 200)
    private String justificacion;

    @Column(nullable = false)
    private String fechaRegistro;

    private String estadoProceso;

    @Column(nullable = false)
    private boolean vigente = true;
}