package com.practica.crud.repository;

import com.practica.crud.model.UniAdm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniAdmRepository extends JpaRepository<UniAdm, Long> {
}