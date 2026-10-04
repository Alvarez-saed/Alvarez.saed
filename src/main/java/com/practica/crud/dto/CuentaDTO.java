package com.practica.crud.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CuentaDTO {
    private Long codigo;
    private String numero;
    private String nombre;
    private String categoria;
    private boolean vigente;
}