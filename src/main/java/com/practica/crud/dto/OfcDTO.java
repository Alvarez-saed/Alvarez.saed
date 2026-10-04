package com.practica.crud.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OfcDTO {
    private Long codigo;
    private String claveOficina;
    private String nombreOficina;
    private String direccion;
    private String telefono;
    private boolean activo;
}