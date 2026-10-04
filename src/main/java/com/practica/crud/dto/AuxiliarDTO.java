package com.practica.crud.dto;

import lombok.Data;

@Data
public class AuxiliarDTO {
    private Long id;
    private String codigo;
    private String nombre;
    private String descripcion;
    private Boolean activo;
}