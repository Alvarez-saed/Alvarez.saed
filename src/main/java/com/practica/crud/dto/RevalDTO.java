package com.practica.crud.dto;

import java.math.BigDecimal;

public class RevalDTO {

    private Long codigo;
    private String claveRevalorizacion;
    private String nombreActivo;

    // ✅ Cambiado a BigDecimal
    private BigDecimal montoAnterior;
    private BigDecimal montoActual;

    private String mesProceso;
    private boolean vigente;

    // Getters y Setters
    public Long getCodigo() { return codigo; }
    public void setCodigo(Long codigo) { this.codigo = codigo; }

    public String getClaveRevalorizacion() { return claveRevalorizacion; }
    public void setClaveRevalorizacion(String claveRevalorizacion) { this.claveRevalorizacion = claveRevalorizacion; }

    public String getNombreActivo() { return nombreActivo; }
    public void setNombreActivo(String nombreActivo) { this.nombreActivo = nombreActivo; }

    public BigDecimal getMontoAnterior() { return montoAnterior; }
    public void setMontoAnterior(BigDecimal montoAnterior) { this.montoAnterior = montoAnterior; }

    public BigDecimal getMontoActual() { return montoActual; }
    public void setMontoActual(BigDecimal montoActual) { this.montoActual = montoActual; }

    public String getMesProceso() { return mesProceso; }
    public void setMesProceso(String mesProceso) { this.mesProceso = mesProceso; }

    public boolean isVigente() { return vigente; }
    public void setVigente(boolean vigente) { this.vigente = vigente; }
}