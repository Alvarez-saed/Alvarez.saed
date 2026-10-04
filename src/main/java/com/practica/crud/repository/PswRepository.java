package com.practica.crud.repository;

import com.practica.crud.model.Psw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PswRepository extends JpaRepository<Psw, Long> {
}