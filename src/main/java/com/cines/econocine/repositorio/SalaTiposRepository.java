package com.cines.econocine.repositorio;

import com.cines.econocine.modelo.SalaTipos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SalaTiposRepository extends JpaRepository<SalaTipos, Integer>, JpaSpecificationExecutor<SalaTipos> {

}