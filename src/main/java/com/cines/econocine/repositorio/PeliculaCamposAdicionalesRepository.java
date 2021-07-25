package com.cines.econocine.repositorio;

import com.cines.econocine.modelo.PeliculaCamposAdicionales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PeliculaCamposAdicionalesRepository extends JpaRepository<PeliculaCamposAdicionales, Integer>, JpaSpecificationExecutor<PeliculaCamposAdicionales> {

}