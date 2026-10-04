package com.practica.crud.model;

import jakarta.persistence.*;

@Entity
@Table(name = "resp")
public class Resp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(nullable = false, length = 50, unique = true)
    private String claveResponsable;

    @Column(nullable = false, length = 120)
    private String nombreCompleto;

    @Column(length = 100)
    private String cargo;

    @Column(length = 200)
    private String area;

    private boolean activo = true;

    // Getters y Setters
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