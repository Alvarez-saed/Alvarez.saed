package com.practica.crud.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DatoDTO {
    private Long idRegistro;
    private String etiqueta;
    private String valor;
    private String grupo;
    private boolean activo;
}