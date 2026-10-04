package com.practica.crud.model;

import jakarta.persistence.*;

@Entity
@Table(name = "unidadadmin")
public class UniAdm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(nullable = false, length = 30, unique = true)
    private String claveUnidad;

    @Column(nullable = false, length = 150)
    private String nombreCompleto;

    @Column(length = 100)
    private String nivelJerarquico;

    @Column(length = 200)
    private String ubicacion;

    private boolean activo = true;

    // Getters y Setters
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