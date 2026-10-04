package com.practica.crud.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstadoEntidadDTO {
    private Long clave;
    private String codigoEstado;
    private String nombreEstado;
    private String descripcion;
    private boolean vigente;
}