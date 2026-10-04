package com.practica.crud.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConfigDTO {
    private Long clave;
    private String nombreParametro;
    private String valorParametro;
    private String detalle;
    private boolean activo;
}