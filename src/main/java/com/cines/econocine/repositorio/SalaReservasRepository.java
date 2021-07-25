package com.cines.econocine.repositorio;

import com.cines.econocine.modelo.SalaReservas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SalaReservasRepository extends JpaRepository<SalaReservas, Integer>, JpaSpecificationExecutor<SalaReservas> {

}