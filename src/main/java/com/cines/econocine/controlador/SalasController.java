package com.cines.econocine.controlador;

import com.cines.econocine.modelo.Ciudades;
import com.cines.econocine.modelo.SalaTipos;
import com.cines.econocine.modelo.Salas;
import com.cines.econocine.modelo.Sucursales;
import com.cines.econocine.repositorio.SalaTiposRepository;
import com.cines.econocine.repositorio.SalasRepository;
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
@RequestMapping("/salas")
public class SalasController {

    private SalasRepository salasRepo;
    private SalaTiposRepository salasTipoRepo;

    public SalasController(SalasRepository salasRepo,
        SalaTiposRepository salasTipoRepo) {
        this.salasRepo = salasRepo;
        this.salasTipoRepo = salasTipoRepo;
    }

    /**
     * Lista las salas con la salida de datos controlada
     * @return
     */
    @GetMapping("/listar")
    public List<Salas> listar() {
        List<Salas> lista;
        List<Salas> listaCast = new ArrayList<>();
        try {
            lista = salasRepo.findAll();
            for (Salas ent : lista) {
                Salas sala = new Salas();
                sala.setId(ent.getId());
                sala.setNombre(ent.getNombre());
                sala.setNumeroFilas(ent.getNumeroFilas());
                sala.setNumeroSillasFila(ent.getNumeroSillasFila());
                sala.setSucursalesBySucursalesId(new Sucursales());
                sala.getSucursalesBySucursalesId().setNombre((ent.getSucursalesBySucursalesId().getNombre()));
                sala.setSalaTiposByTipoSalaId(new SalaTipos());
                sala.getSalaTiposByTipoSalaId().setNombre(ent.getNombre());
                sala.setFechaHoraCrea(ent.getFechaHoraCrea());
                sala.setTerminalCrea(ent.getTerminalCrea());
                sala.setUsuarioCrea(ent.getUsuarioCrea());
                listaCast.add(sala);
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return listaCast;
    }

    @PreAuthorize("hasRole('admin')")
    @GetMapping("/ver")
    public Optional ver(@RequestParam("data") Integer id) {
        return salasRepo.findById(id);
    }

    @PreAuthorize("hasRole('admin')")
    @PostMapping("/guardar")
    public Salas guardar(@RequestBody Salas salaNueva, HttpServletRequest request) {
        salaNueva.setFechaHoraCrea(new Timestamp(new Date().getTime()));
        salaNueva.setTerminalCrea(request.getRemoteAddr());
        return salasRepo.save(salaNueva);
    }

    /**
     * Lista las salas con la salida de datos controlada
     * @return
     */
    @GetMapping("/listarTipos")
    public List<SalaTipos> listarTipos() {
        List<SalaTipos> lista=  salasTipoRepo.findAll();
        List<SalaTipos> listaCast=  new ArrayList<>();
        for (SalaTipos tipo : lista) {
            SalaTipos tipoCast = new SalaTipos();
            tipoCast.setId(tipo.getId());
            tipoCast.setNombre(tipo.getNombre());
            listaCast.add(tipoCast);
        }
        return listaCast;
     }

}
