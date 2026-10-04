package com.practica.crud.dto;

public class UniAdmDTO {
    private Long codigo;
    private String claveUnidad;
    private String nombreCompleto;
    private String nivelJerarquico;
    private String ubicacion;
    private boolean activo;

    public Long getCodigo() { return codigo; }
    public void setCodigo(Long codigo) { this.codigo = codigo; }

    public String getClaveUnidad() { return claveUnidad; }
    public void setClaveUnidad(String claveUnidad) { this.claveUnidad = claveUnidad; }

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    public String getNivelJerarquico() { return nivelJerarquico; }
    public void setNivelJerarquico(String nivelJerarquico) { this.nivelJerarquico = nivelJerarquico; }

    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }
}