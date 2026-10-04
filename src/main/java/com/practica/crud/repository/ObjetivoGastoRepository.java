package com.practica.crud.repository;

import com.practica.crud.model.ObjetivoGasto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjetivoGastoRepository extends JpaRepository<ObjetivoGasto, Long> {
}