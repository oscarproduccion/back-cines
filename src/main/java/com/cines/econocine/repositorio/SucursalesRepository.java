package com.cines.econocine.repositorio;

import com.cines.econocine.modelo.Sucursales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface SucursalesRepository extends JpaRepository<Sucursales, Integer>, JpaSpecificationExecutor<Sucursales> {

    @Query(value="SELECT s.id, s.nombre as nombreSucursal, s.direccion, c.nombre as nombreCiudad, " +
            "s.fecha_hora_crea as fechaHoraCrea, " +
            "s.terminal_crea as terminalCrea, " +
            "s.usuario_crea as usuarioCrea " +
            "FROM sucursales s " +
            "INNER JOIN ciudades c " +
            "ON c.id = s.ciudades_id ", nativeQuery=true)
    List<ISucursales> findAllBy();

    /**
     * IFace Sucursales Publico
     */
    interface ISucursales {
        Long getId();
        String getNombreSucursal();
        String getDireccion();
        String getNombreCiudad();
        Timestamp getFechaHoraCrea();
        String getTerminalCrea();
        String getUsuarioCrea();
    }
}