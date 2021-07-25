package com.cines.econocine.controlador;

import com.cines.econocine.modelo.Ciudades;
import com.cines.econocine.modelo.Sucursales;
import com.cines.econocine.repositorio.CiudadesRepository;
import com.cines.econocine.repositorio.SucursalesRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/sucursales")
public class SucursalesController {

    private SucursalesRepository sucursalesRepo;

    public SucursalesController(SucursalesRepository sucursalesRepo) {
        this.sucursalesRepo = sucursalesRepo;
    }

    /**
     * Lista las sucursales con la salida de datos controlada
     * @return
     */
    @GetMapping("/listar")
    public List<Sucursales> listar() {
        List<SucursalesRepository.ISucursales> lista;
        List<Sucursales> listaCast = new ArrayList<>();
        try {
            lista = sucursalesRepo.findAllBy();
            for (SucursalesRepository.ISucursales sucursalDto : lista) {
                Sucursales sucursal = new Sucursales();
                sucursal.setId(sucursalDto.getId().intValue());
                sucursal.setNombre(sucursalDto.getNombreSucursal());
                sucursal.setDireccion(sucursalDto.getDireccion());
                sucursal.setCiudadesByCiudadesId(new Ciudades());
                sucursal.getCiudadesByCiudadesId().setNombre((sucursalDto.getNombreCiudad()));
                sucursal.setFechaHoraCrea(sucursalDto.getFechaHoraCrea());
                sucursal.setTerminalCrea(sucursalDto.getTerminalCrea());
                sucursal.setUsuarioCrea(sucursalDto.getUsuarioCrea());
                listaCast.add(sucursal);
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return listaCast;
    }

    @PreAuthorize("hasRole('admin')")
    @GetMapping("/ver")
    public Optional ver(@RequestParam("data") Integer id) {
        return sucursalesRepo.findById(id);
    }

    @PreAuthorize("hasRole('admin')")
    @PostMapping("/guardar")
    public Sucursales guardar(@RequestBody Sucursales sucursalNueva, HttpServletRequest request) {
        sucursalNueva.setAdministrador("N/A");
        sucursalNueva.setFechaHoraCrea(new Timestamp(new Date().getTime()));
        sucursalNueva.setTerminalCrea(request.getRemoteAddr());
        return sucursalesRepo.save(sucursalNueva);
    }

}
