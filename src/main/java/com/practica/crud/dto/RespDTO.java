package com.practica.crud.dto;

public class RespDTO {
    private Long codigo;
    private String claveResponsable;
    private String nombreCompleto;
    private String cargo;
    private String area;
    private boolean activo;

    public Long getCodigo() { return codigo; }
    public void setCodigo(Long codigo) { this.codigo = codigo; }

    public String getClaveResponsable() { return claveResponsable; }
    public void setClaveResponsable(String claveResponsable) { this.claveResponsable = claveResponsable; }

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }

    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }
}