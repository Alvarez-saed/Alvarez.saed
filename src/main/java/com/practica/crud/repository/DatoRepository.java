package com.practica.crud.repository;

import com.practica.crud.model.Dato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatoRepository extends JpaRepository<Dato, Long> {
}