package com.practica.crud.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ObjetivoGastoDTO {
    private Long codigoRegistro;
    private String claveObjetivo;
    private String descripcion;
    private String categoria;
    private boolean vigente;
}