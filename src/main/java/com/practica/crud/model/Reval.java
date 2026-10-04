package com.practica.crud.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "reval")
public class Reval {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(nullable = false, length = 30, unique = true)
    private String claveRevalorizacion;

    @Column(nullable = false, length = 100)
    private String nombreActivo;

    // ✅ Cambiado a BigDecimal → SÍ permite precision y scale
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal montoAnterior;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal montoActual;

    @Column(length = 10)
    private String mesProceso;

    private boolean vigente = true;

    // Getters y Setters actualizados
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