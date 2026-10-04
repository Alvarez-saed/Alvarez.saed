package com.practica.crud.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cla_depts")
public class ClaDepts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long claveId;

    @Column(name = "codigo_departamento", nullable = false, length = 20, unique = true)
    private String codDepto;

    @Column(name = "nombre_departamento", nullable = false, length = 120)
    private String nombreDepartamento;

    @Column(length = 200)
    private String descripcionArea;

    private String nivelJerarquico;

    @Column(nullable = false)
    private boolean estadoActivo = true;
}