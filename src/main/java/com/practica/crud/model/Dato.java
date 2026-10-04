package com.practica.crud.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "data")
public class Dato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRegistro;

    @Column(nullable = false, length = 50)
    private String etiqueta;

    @Column(nullable = false, length = 255)
    private String valor;

    @Column(length = 100)
    private String grupo;

    private boolean activo = true;
}