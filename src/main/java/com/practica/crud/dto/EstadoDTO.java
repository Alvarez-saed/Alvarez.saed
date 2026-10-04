package com.practica.crud.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstadoDTO {
    private Long identificador;
    private String claveEstado;
    private String nombreEstado;
    private String detalle;
    private boolean activo;
}