package com.practica.crud.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "baja")
public class Baja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20, unique = true)
    private String codigo;

    @Column(nullable = false, length = 150)
    private String nombreElemento;

    @Column(length = 255)
    private String motivo;

    private LocalDate fechaBaja;

    @Column(length = 50)
    private String estado;

    private Boolean activo = true;
}