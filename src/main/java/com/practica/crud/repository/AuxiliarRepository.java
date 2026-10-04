package com.practica.crud.repository;

import com.practica.crud.model.Auxiliar;  // ← model
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuxiliarRepository extends JpaRepository<Auxiliar, Long> {
}