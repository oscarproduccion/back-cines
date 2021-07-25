package com.cines.econocine.repositorio;

import com.cines.econocine.modelo.Peliculas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PeliculasRepository extends JpaRepository<Peliculas, Integer>, JpaSpecificationExecutor<Peliculas> {

}