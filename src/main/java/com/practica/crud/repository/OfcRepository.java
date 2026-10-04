package com.practica.crud.repository;

import com.practica.crud.model.Ofc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfcRepository extends JpaRepository<Ofc, Long> {
}