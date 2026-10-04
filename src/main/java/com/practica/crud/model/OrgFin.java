package com.practica.crud.model;

import jakarta.persistence.*;

@Entity
@Table(name = "organismo_fin")
public class OrgFin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(nullable = false, length = 30, unique = true)
    private String clave;

    @Column(nullable = false, length = 150)
    private String nombre;

    @Column(length = 100)
    private String nivel;

    private boolean activo = true;

    // Getters y Setters (sin Lombok para evitar errores)
    public Long getCodigo() { return codigo; }
    public void setCodigo(Long codigo) { this.codigo = codigo; }

    public String getClave() { return clave; }
    public void setClave(String clave) { this.clave = clave; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getNivel() { return nivel; }
    public void setNivel(String nivel) { this.nivel = nivel; }

    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }
}