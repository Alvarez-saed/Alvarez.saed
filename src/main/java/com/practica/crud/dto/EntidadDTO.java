package com.practica.crud.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntidadDTO {
    private Long codigoInterno;
    private String sigla;
    private String nombreCompleto;
    private String direccion;
    private String telefono;
    private boolean estadoActivo;
}