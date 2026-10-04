package com.practica.crud.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClaDeptsDTO {
    private Long claveId;
    private String codDepto;
    private String nombreDepartamento;
    private String descripcionArea;
    private String nivelJerarquico;
    private boolean estadoActivo;
}