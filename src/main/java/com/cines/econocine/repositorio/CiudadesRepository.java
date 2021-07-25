package com.cines.econocine.repositorio;

import com.cines.econocine.modelo.Ciudades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CiudadesRepository extends JpaRepository<Ciudades, Integer>, JpaSpecificationExecutor<Ciudades> {

}