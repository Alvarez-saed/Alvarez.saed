package com.practica.crud.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CodcontDTO {
    private Long identificador;
    private String codigoCuenta;
    private String nombreCuenta;
    private String tipoCuenta;
    private Integer nivelJerarquico;
    private boolean vigente;
}