package com.practica.crud.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class BackupsDTO {
    private Long id;
    private String nombre;
    private String rutaArchivo;
    private LocalDateTime fechaCreacion;
    private String tamaño;
    private Boolean activo;
}