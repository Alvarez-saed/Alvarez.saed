package com.practica.crud.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "mes")
public class Mes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoInterno;

    @Column(nullable = false, length = 2, unique = true)
    private String numeroMes;

    @Column(nullable = false, length = 20)
    private String nombreMes;

    @Column(nullable = false)
    private Integer diasTotales;

    private boolean activo = true;
}