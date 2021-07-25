package com.cines.econocine.repositorio;

import com.cines.econocine.modelo.Salas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface SalasRepository extends JpaRepository<Salas, Integer>, JpaSpecificationExecutor<Salas> {
    List<Salas> findAllBySucursalesBySucursalesId_Id(Integer sucursalId);

}