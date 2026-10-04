package com.practica.crud.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "trasfe")
public class Trasfe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(nullable = false, length = 30, unique = true)
    private String claveTraslado;

    @Column(nullable = false, length = 100)
    private String origen;

    @Column(nullable = false, length = 100)
    private String destino;

    // ✅ Cambiado a BigDecimal
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal montoMovimiento;

    @Column(length = 10)
    private String fechaOperacion;

    private boolean confirmado = false;

    // Getters y Setters actualizados
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