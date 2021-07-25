package com.cines.econocine.controlador;

import com.cines.econocine.modelo.PeliculaSucursales;
import com.cines.econocine.modelo.Peliculas;
import com.cines.econocine.modelo.Salas;
import com.cines.econocine.modelo.Sucursales;
import com.cines.econocine.repositorio.PeliculaSucursalesRepository;
import com.cines.econocine.repositorio.PeliculasRepository;
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
@RequestMapping("/peliculasucursales")
public class PeliculaSucursalesController {

    private PeliculaSucursalesRepository peliculaSucursalRepo;
    private SalasRepository salaRepo;

    public PeliculaSucursalesController(PeliculaSucursalesRepository peliculaSucursalRepo,
                                        SalasRepository salaRepo) {
        this.peliculaSucursalRepo = peliculaSucursalRepo;
        this.salaRepo = salaRepo;
    }

    /**
     * Lista todas las peliculas
     * @return
     */
    @GetMapping("/listar")
    public List<PeliculaSucursales> listar() {
        List<PeliculaSucursales> lista = peliculaSucursalRepo.findAll();
        List<PeliculaSucursales> listaCast = new ArrayList<>();
        for (PeliculaSucursales peliculaSucursal : lista) {
            PeliculaSucursales peliculaSucursalCast = new PeliculaSucursales();
            peliculaSucursalCast.setId(peliculaSucursal.getId());
            peliculaSucursalCast.setSucursalesBySucursalesId(new Sucursales());
            peliculaSucursalCast.setPeliculasByPeliculasId(new Peliculas());
            peliculaSucursalCast.getSucursalesBySucursalesId().setNombre(peliculaSucursal.getSucursalesBySucursalesId().getNombre());
            peliculaSucursalCast.getPeliculasByPeliculasId().setNombreOriginal(peliculaSucursal.getPeliculasByPeliculasId().getNombreOriginal());
            peliculaSucursalCast.setUsuarioCrea(peliculaSucursal.getUsuarioCrea());
            peliculaSucursalCast.setTerminalCrea(peliculaSucursal.getTerminalCrea());
            peliculaSucursalCast.setFechaHoraCrea(peliculaSucursal.getFechaHoraCrea());
            listaCast.add(peliculaSucursalCast);
        }
        return listaCast;
    }

    /**
     * Lista las peliculas por sucursal
     * @return
     */
    @GetMapping("/listarPeliculasPorSucursal")
    public List<Peliculas> listarPeliculasPorSucursal(@RequestParam("sucursalId") String sucursalId) {
        List<PeliculaSucursales> lista = peliculaSucursalRepo.findAllBySucursalesBySucursalesId_Id(Integer.valueOf(sucursalId));
        List<Peliculas> listaCast = new ArrayList<>();
        for (PeliculaSucursales peliculaSucursal : lista) {
            Peliculas peliculaCast = new Peliculas();
            peliculaCast.setId(peliculaSucursal.getId());
            peliculaCast.setNombreOriginal(peliculaSucursal.getPeliculasByPeliculasId().getNombreOriginal());
            peliculaCast.setId(peliculaSucursal.getPeliculasByPeliculasId().getId());
            listaCast.add(peliculaCast);
        }
        return listaCast;
    }

    /**
     * Lista salas por sucursal
     * @return
     */
    @GetMapping("/listarSalasPorSucursal")
    public List<Salas> listarSalaPorSucursal(@RequestParam("sucursalId") String sucursalId) {
        List<Salas> lista = salaRepo.findAllBySucursalesBySucursalesId_Id(Integer.valueOf(sucursalId));
        List<Salas> listaCast = new ArrayList<>();
        for (Salas sala : lista) {
            Salas salaCast = new Salas();
            salaCast.setId(sala.getId());
            salaCast.setNombre(sala.getNombre());
            listaCast.add(salaCast);
        }
        return listaCast;
    }

    @PreAuthorize("hasRole('admin')")
    @GetMapping("/ver")
    public Optional<PeliculaSucursales> ver(@RequestParam("data") Integer id) {
        return peliculaSucursalRepo.findById(id);
    }

    @PreAuthorize("hasRole('admin')")
    @PostMapping("/guardar")
    public PeliculaSucursales guardar(@RequestBody PeliculaSucursales peliculaSucursalNueva, HttpServletRequest request) {
        peliculaSucursalNueva.setFechaHoraCrea(new Timestamp(new Date().getTime()));
        peliculaSucursalNueva.setTerminalCrea(request.getRemoteAddr());
        return peliculaSucursalRepo.save(peliculaSucursalNueva);
    }

}
