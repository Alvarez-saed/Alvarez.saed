package com.practica.crud.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "entidades")
public class Entidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoInterno;

    @Column(nullable = false, length = 30, unique = true)
    private String sigla;

    @Column(nullable = false, length = 150)
    private String nombreCompleto;

    @Column(length = 200)
    private String direccion;

    @Column(length = 20)
    private String telefono;

    private boolean estadoActivo = true;
}