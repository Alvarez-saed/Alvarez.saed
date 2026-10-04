package com.practica.crud.repository;

import com.practica.crud.model.Rpt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RptRepository extends JpaRepository<Rpt, Long> {
}