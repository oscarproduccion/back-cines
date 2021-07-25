package com.cines.econocine.controlador;

import com.cines.econocine.modelo.*;
import com.cines.econocine.repositorio.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/reservas")
public class SalaReservasController {

    private SalaReservasRepository reservasRepo;
    private PeliculaAgendasRepository agendaRepo;
    private UsuariosRepository usuarioRepo;

    public SalaReservasController(SalaReservasRepository reservasRepo,
                                PeliculaAgendasRepository agendaRepo,
                                UsuariosRepository usuarioRepo) {
        this.reservasRepo = reservasRepo;
        this.agendaRepo = agendaRepo;
        this.usuarioRepo = usuarioRepo;
    }

    /**
     * Lista las salas con la salida de datos controlada
     * @return
     */
    @PreAuthorize("hasRole('admin')")
    @GetMapping("/listar")
    public List<SalaReservas> listar() {
        List<SalaReservas> lista = reservasRepo.findAll();
        List<SalaReservas> listaCast = new ArrayList<>();
        for (SalaReservas salaReserva : lista) {
            SalaReservas salaReservaCast = new SalaReservas();
            salaReservaCast.setSalasBySalasId(new Salas());
            salaReservaCast.setPeliculaAgendasByPeliculaAgendasId(new PeliculaAgendas());
            salaReservaCast.setUsuariosByUsuarioId(new Usuarios());
            salaReservaCast.getPeliculaAgendasByPeliculaAgendasId().setSucursalesBySucursalesId(new Sucursales());
            salaReservaCast.getPeliculaAgendasByPeliculaAgendasId().setPeliculasByPeliculasId(new Peliculas());
            salaReservaCast.getPeliculaAgendasByPeliculaAgendasId().getSucursalesBySucursalesId().setNombre(salaReserva.getPeliculaAgendasByPeliculaAgendasId().getSucursalesBySucursalesId().getNombre());
            salaReservaCast.getPeliculaAgendasByPeliculaAgendasId().getPeliculasByPeliculasId().setNombreOriginal(salaReserva.getPeliculaAgendasByPeliculaAgendasId().getPeliculasByPeliculasId().getNombreOriginal());
            salaReservaCast.getPeliculaAgendasByPeliculaAgendasId().setFechaHoraAgenda(salaReserva.getPeliculaAgendasByPeliculaAgendasId().getFechaHoraAgenda());
            salaReservaCast.getSalasBySalasId().setNombre(salaReserva.getSalasBySalasId().getNombre());
            salaReservaCast.getUsuariosByUsuarioId().setEmail(salaReserva.getUsuariosByUsuarioId().getEmail());
            salaReservaCast.setValorPago(salaReserva.getValorPago());
            salaReservaCast.setFila(salaReserva.getFila());
            salaReservaCast.setSilla(salaReserva.getSilla());
            salaReservaCast.setPagado(salaReserva.isPagado());
            salaReservaCast.setUsuarioCrea(salaReserva.getUsuarioCrea());
            salaReservaCast.setFechaHoraCrea(salaReserva.getFechaHoraCrea());
            salaReservaCast.setTerminalCrea(salaReserva.getTerminalCrea());
            listaCast.add(salaReservaCast);
        }
        return listaCast;
    }

    @PreAuthorize("hasRole('admin')")
    @GetMapping("/ver")
    public Optional<SalaReservas> ver(@RequestParam("data") Integer id) {
        return reservasRepo.findById(id);
    }

    @PreAuthorize("hasRole('admin')")
    @PostMapping("/guardar")
    public SalaReservas guardar(@RequestBody SalaReservas reservaNueva, HttpServletRequest request) {
        reservaNueva.setSalasBySalasId(agendaRepo.findById(reservaNueva.getPeliculaAgendasByPeliculaAgendasId().getId()).get().getSalasBySalasId());
        reservaNueva.setFechaHoraAgenda(new Timestamp(new Date().getTime()));
        reservaNueva.setFechaHoraPago(new Timestamp(new Date().getTime()));
        reservaNueva.setPagado(true);
        reservaNueva.setUsuariosByUsuarioId(usuarioRepo.findByEmail(reservaNueva.getUsuarioCrea()));
        reservaNueva.setFechaHoraCrea(new Timestamp(new Date().getTime()));
        reservaNueva.setTerminalCrea(request.getRemoteAddr());
        return reservasRepo.save(reservaNueva);
    }

    /**
     * Lista las agendas de una sala
     * @return
     */
    @GetMapping("/listarAgendaPorPeliculaSucursal")
    public List<PeliculaAgendas> listarAgendasPorPeliculaSucursal(@RequestParam("peliculaId") String peliculaId,
                                                        @RequestParam("sucursalId") String sucursalId) {
        List<PeliculaAgendas> lista = agendaRepo.findAllByPeliculasByPeliculasId_IdAndSucursalesBySucursalesId_Id(Integer.valueOf(peliculaId), Integer.valueOf(sucursalId));
        List<PeliculaAgendas> listaCast = new ArrayList<>();
        for (PeliculaAgendas agenda : lista) {
            PeliculaAgendas agendaCast = new PeliculaAgendas();
            agendaCast.setId(agenda.getId());
            agendaCast.setSalasBySalasId(new Salas());
            agendaCast.getSalasBySalasId().setNombre(agenda.getSalasBySalasId().getNombre());
            agendaCast.setFechaHoraAgenda(agenda.getFechaHoraAgenda());
            listaCast.add(agendaCast);
        }
        return listaCast;
    }

}
