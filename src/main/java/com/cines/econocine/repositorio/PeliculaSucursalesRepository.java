package com.cines.econocine.repositorio;

import com.cines.econocine.modelo.PeliculaSucursales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface PeliculaSucursalesRepository extends JpaRepository<PeliculaSucursales, Integer>, JpaSpecificationExecutor<PeliculaSucursales> {

    List<PeliculaSucursales> findAllBySucursalesBySucursalesId_Id(Integer sucursalId);

}