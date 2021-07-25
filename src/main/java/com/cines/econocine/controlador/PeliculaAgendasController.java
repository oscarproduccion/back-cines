package com.cines.econocine.controlador;

import com.cines.econocine.modelo.*;
import com.cines.econocine.repositorio.PeliculaAgendasRepository;
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
@RequestMapping("/agendas")
public class PeliculaAgendasController {

    private PeliculaAgendasRepository agendaRepo;

    public PeliculaAgendasController(PeliculaAgendasRepository agendaRepo) {
        this.agendaRepo = agendaRepo;
    }

    /**
     * Lista los agendamientos por sucursal, sala y pelicula
     * @return
     */
    @GetMapping("/listar")
    public List<PeliculaAgendas> listar() {
        List<PeliculaAgendas> lista = agendaRepo.findAll();
        List<PeliculaAgendas> listaCast = new ArrayList<>();
        for (PeliculaAgendas peliculaAgenda : lista) {
            PeliculaAgendas peliculaAgendaCast = new PeliculaAgendas();
            peliculaAgendaCast.setPeliculasByPeliculasId(new Peliculas());
            peliculaAgendaCast.setSucursalesBySucursalesId(new Sucursales());
            peliculaAgendaCast.setSalasBySalasId(new Salas());
            peliculaAgendaCast.getPeliculasByPeliculasId().setNombreOriginal(peliculaAgenda.getPeliculasByPeliculasId().getNombreOriginal());
            peliculaAgendaCast.getSucursalesBySucursalesId().setNombre(peliculaAgenda.getSucursalesBySucursalesId().getNombre());
            peliculaAgendaCast.getSalasBySalasId().setNombre(peliculaAgenda.getSalasBySalasId().getNombre());
            peliculaAgendaCast.setFechaHoraAgenda(peliculaAgenda.getFechaHoraAgenda());
            peliculaAgendaCast.setFechaHoraCrea(peliculaAgenda.getFechaHoraCrea());
            peliculaAgendaCast.setTerminalCrea(peliculaAgenda.getTerminalCrea());
            peliculaAgendaCast.setUsuarioCrea(peliculaAgenda.getUsuarioCrea());
            listaCast.add(peliculaAgendaCast);
        }
        return listaCast;
    }

    @PreAuthorize("hasRole('admin')")
    @GetMapping("/ver")
    public Optional ver(@RequestParam("data") Integer id) {
        return agendaRepo.findById(id);
    }

    @PreAuthorize("hasRole('admin')")
    @PostMapping("/guardar")
    public PeliculaAgendas guardar(@RequestBody PeliculaAgendas agendaNueva, HttpServletRequest request) {
        agendaNueva.setFechaHoraCrea(new Timestamp(new Date().getTime()));
        agendaNueva.setTerminalCrea(request.getRemoteAddr());
        return agendaRepo.save(agendaNueva);
    }

}
