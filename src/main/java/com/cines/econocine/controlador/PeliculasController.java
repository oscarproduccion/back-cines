package com.cines.econocine.controlador;

import com.cines.econocine.modelo.Peliculas;
import com.cines.econocine.modelo.SalaTipos;
import com.cines.econocine.modelo.Salas;
import com.cines.econocine.modelo.Sucursales;
import com.cines.econocine.repositorio.PeliculasRepository;
import com.cines.econocine.repositorio.SalaTiposRepository;
import com.cines.econocine.repositorio.SalasRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/peliculas")
public class PeliculasController {

    private PeliculasRepository peliculasRepo;

    public PeliculasController(PeliculasRepository peliculasRepo) {
        this.peliculasRepo = peliculasRepo;
    }

    /**
     * Lista las peliculas
     * @return
     */
    @GetMapping("/listar")
    public List<Peliculas> listar() {

        List<Peliculas> lista = peliculasRepo.findAll();
        List<Peliculas> listaCast = new ArrayList<>();
        for (Peliculas pelicula : lista) {
            Peliculas peliculaCast = new Peliculas();
            peliculaCast.setId(pelicula.getId());
            peliculaCast.setNombreOriginal(pelicula.getNombreOriginal());
            peliculaCast.setNombreTraduccion(pelicula.getNombreTraduccion());
            peliculaCast.setFechaEstreno(pelicula.getFechaEstreno());
            peliculaCast.setFechaBaja(pelicula.getFechaBaja());
            peliculaCast.setDuracion(pelicula.getDuracion());
            peliculaCast.setFormato(pelicula.getFormato());
            peliculaCast.setUsuarioCrea(pelicula.getUsuarioCrea());
            peliculaCast.setFechaHoraCrea(pelicula.getFechaHoraCrea());
            listaCast.add(peliculaCast);
        }
        return listaCast;
    }

    @PreAuthorize("hasRole('admin')")
    @GetMapping("/ver")
    public Optional<Peliculas> ver(@RequestParam("data") Integer id) {
        return peliculasRepo.findById(id);
    }

    @PreAuthorize("hasRole('admin')")
    @PostMapping("/guardar")
    public Peliculas guardar(@RequestBody Peliculas peliculaNueva, HttpServletRequest request) {
        peliculaNueva.setFechaHoraCrea(new Timestamp(new Date().getTime()));
        peliculaNueva.setTerminalCrea(request.getRemoteAddr());
        return peliculasRepo.save(peliculaNueva);
    }

}
