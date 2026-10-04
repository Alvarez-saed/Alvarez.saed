package com.practica.crud.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class BajaDTO {
    private Long id;
    private String codigo;
    private String nombreElemento;
    private String motivo;
    private LocalDate fechaBaja;
    private String estado;
    private Boolean activo;
}