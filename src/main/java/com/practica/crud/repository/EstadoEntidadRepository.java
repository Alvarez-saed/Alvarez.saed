package com.practica.crud.repository;

import com.practica.crud.model.EstadoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoEntidadRepository extends JpaRepository<EstadoEntidad, Long> {
}