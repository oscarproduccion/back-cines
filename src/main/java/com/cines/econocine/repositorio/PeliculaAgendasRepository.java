package com.cines.econocine.repositorio;

import com.cines.econocine.modelo.PeliculaAgendas;
import com.cines.econocine.modelo.PeliculaSucursales;
import com.cines.econocine.modelo.Salas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface PeliculaAgendasRepository extends JpaRepository<PeliculaAgendas, Integer>, JpaSpecificationExecutor<PeliculaAgendas> {
    List<PeliculaAgendas> findAllByPeliculasByPeliculasId_IdAndSucursalesBySucursalesId_Id(Integer peliculaId, Integer sucursalId);
}