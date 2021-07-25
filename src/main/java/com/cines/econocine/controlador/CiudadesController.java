package com.cines.econocine.controlador;

import com.cines.econocine.modelo.Ciudades;
import com.cines.econocine.repositorio.CiudadesRepository;
import com.cines.econocine.repositorio.UsuariosRepository;
import com.cines.econocine.servicio.autenticacion.SolicitudRegistro;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/ciudades")
public class CiudadesController {

    private CiudadesRepository ciudadesRepo;

    public CiudadesController(CiudadesRepository ciudadesRepo) {
        this.ciudadesRepo = ciudadesRepo;
    }

    @GetMapping("/listar")
    public List<Ciudades> listar() {
        List<Ciudades> lista =  ciudadesRepo.findAll();
        List<Ciudades> listaCast = new ArrayList<>();
        for (Ciudades ciudad : lista) {
            Ciudades ciudadCast = new Ciudades();
            ciudadCast.setNombre(ciudad.getNombre());
            ciudadCast.setId(ciudad.getId());
            ciudadCast.setUsuarioCrea(ciudad.getUsuarioCrea());
            ciudadCast.setTerminalCrea(ciudad.getTerminalCrea());
            ciudadCast.setFechaHoraCrea(ciudad.getFechaHoraCrea());
            listaCast.add(ciudadCast);
        }
        return listaCast;
    }

    @PreAuthorize("hasRole('admin')")
    @GetMapping("/ver")
    public Optional ver(@RequestParam("data") Integer id) {
        return ciudadesRepo.findById(id);
    }

    @PreAuthorize("hasRole('admin')")
    @PostMapping("/guardar")
    public Ciudades guardar(@RequestBody Ciudades ciudadNueva, HttpServletRequest request) {
        ciudadNueva.setFechaHoraCrea(new Timestamp(new Date().getTime()));
        ciudadNueva.setTerminalCrea(request.getRemoteAddr());
        return ciudadesRepo.save(ciudadNueva);
    }

}
