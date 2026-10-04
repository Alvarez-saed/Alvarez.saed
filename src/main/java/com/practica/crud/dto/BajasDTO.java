package com.practica.crud.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BajasDTO {
    private Long codigoRegistro;
    private String numeroBaja;
    private String descripcionElemento;
    private String justificacion;
    private String fechaRegistro;
    private String estadoProceso;
    private boolean vigente;
}