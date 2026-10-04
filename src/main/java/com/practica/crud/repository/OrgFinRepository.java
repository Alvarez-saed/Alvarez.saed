package com.practica.crud.repository;

import com.practica.crud.model.OrgFin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrgFinRepository extends JpaRepository<OrgFin, Long> {
}