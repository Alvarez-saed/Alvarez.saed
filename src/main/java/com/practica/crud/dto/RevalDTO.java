package com.practica.crud.dto;

public class RevalDTO {
    private Long codigo;
    private String claveRevalorizacion;
    private String nombreActivo;
    private Double montoAnterior;
    private Double montoActual;
    private String mesProceso;
    private boolean vigente;

    public Long getCodigo() { return codigo; }
    public void setCodigo(Long codigo) { this.codigo = codigo; }

    public String getClaveRevalorizacion() { return claveRevalorizacion; }
    public void setClaveRevalorizacion(String claveRevalorizacion) { this.claveRevalorizacion = claveRevalorizacion; }

    public String getNombreActivo() { return nombreActivo; }
    public void setNombreActivo(String nombreActivo) { this.nombreActivo = nombreActivo; }

    public Double getMontoAnterior() { return montoAnterior; }
    public void setMontoAnterior(Double montoAnterior) { this.montoAnterior = montoAnterior; }

    public Double getMontoActual() { return montoActual; }
    public void setMontoActual(Double montoActual) { this.montoActual = montoActual; }

    public String getMesProceso() { return mesProceso; }
    public void setMesProceso(String mesProceso) { this.mesProceso = mesProceso; }

    public boolean isVigente() { return vigente; }
    public void setVigente(boolean vigente) { this.vigente = vigente; }
}