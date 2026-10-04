package com.practica.crud.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MesDTO {
    private Long codigoInterno;
    private String numeroMes;
    private String nombreMes;
    private Integer diasTotales;
    private boolean activo;
}