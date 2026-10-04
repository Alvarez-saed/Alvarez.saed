package com.practica.crud.repository;

import com.practica.crud.model.OrgUsr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrgUsrRepository extends JpaRepository<OrgUsr, Long> {
}