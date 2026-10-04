package com.practica.crud.dto;

public class TrasfeDTO {
    private Long codigo;
    private String claveTraslado;
    private String origen;
    private String destino;
    private Double montoMovimiento;
    private String fechaOperacion;
    private boolean confirmado;

    public Long getCodigo() { return codigo; }
    public void setCodigo(Long codigo) { this.codigo = codigo; }

    public String getClaveTraslado() { return claveTraslado; }
    public void setClaveTraslado(String claveTraslado) { this.claveTraslado = claveTraslado; }

    public String getOrigen() { return origen; }
    public void setOrigen(String origen) { this.origen = origen; }

    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }

    public Double getMontoMovimiento() { return montoMovimiento; }
    public void setMontoMovimiento(Double montoMovimiento) { this.montoMovimiento = montoMovimiento; }

    public String getFechaOperacion() { return fechaOperacion; }
    public void setFechaOperacion(String fechaOperacion) { this.fechaOperacion = fechaOperacion; }

    public boolean isConfirmado() { return confirmado; }
    public void setConfirmado(boolean confirmado) { this.confirmado = confirmado; }
}