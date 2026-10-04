package com.practica.crud.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "backups")
public class Backups {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 255)
    private String rutaArchivo;

    private LocalDateTime fechaCreacion;

    @Column(length = 50)
    private String tamaño;

    private Boolean activo = true;
}