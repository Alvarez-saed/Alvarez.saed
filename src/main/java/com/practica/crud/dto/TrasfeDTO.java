package com.practica.crud.dto;

import java.math.BigDecimal;

public class TrasfeDTO {

    private Long codigo;
    private String claveTraslado;
    private String origen;
    private String destino;

    // ✅ Cambiado a BigDecimal
    private BigDecimal montoMovimiento;

    private String fechaOperacion;
    private boolean confirmado;

    // Getters y Setters
    public Long getCodigo() { return codigo; }
    public void setCodigo(Long codigo) { this.codigo = codigo; }

    public String getClaveTraslado() { return claveTraslado; }
    public void setClaveTraslado(String claveTraslado) { this.claveTraslado = claveTraslado; }

    public String getOrigen() { return origen; }
    public void setOrigen(String origen) { this.origen = origen; }

    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }

    public BigDecimal getMontoMovimiento() { return montoMovimiento; }
    public void setMontoMovimiento(BigDecimal montoMovimiento) { this.montoMovimiento = montoMovimiento; }

    public String getFechaOperacion() { return fechaOperacion; }
    public void setFechaOperacion(String fechaOperacion) { this.fechaOperacion = fechaOperacion; }

    public boolean isConfirmado() { return confirmado; }
    public void setConfirmado(boolean confirmado) { this.confirmado = confirmado; }
}