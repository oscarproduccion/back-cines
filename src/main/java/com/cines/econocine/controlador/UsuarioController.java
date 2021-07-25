package com.cines.econocine.controlador;

import com.cines.econocine.modelo.Usuarios;
import com.cines.econocine.repositorio.UsuariosRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuariosRepository usuarioRepo;

    public UsuarioController(UsuariosRepository usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    @PreAuthorize("hasRole('admin')")
    @GetMapping("/listar")
    public List<UsuariosRepository.IUsuarios> displayUsers() {
        return usuarioRepo.findAllBy();

    }

    @GetMapping("/ver")
    @PreAuthorize("hasRole('admin')")
    public String displayToUser() {
        return "Display to both user and admin";
    }

    @GetMapping("/displayadmin")
    public String displayToAdmin() {
        return "Display only to admin";
    }

}
