package com.cines.econocine.controlador;

import java.sql.Timestamp;
import java.util.*;

import com.cines.econocine.constantes.Autenticacion;
import com.cines.econocine.modelo.Roles;
import com.cines.econocine.modelo.UsuarioRoles;
import com.cines.econocine.modelo.Usuarios;
import com.cines.econocine.repositorio.RolesRepository;
import com.cines.econocine.repositorio.UsuarioRolesRepository;
import com.cines.econocine.repositorio.UsuariosRepository;
import com.cines.econocine.servicio.autenticacion.SolicitudRegistro;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private UsuariosRepository usuarioRepo;
    private RolesRepository rolesRepo;
    private UsuarioRolesRepository usuarioRolesrepo;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthController(UsuariosRepository usuarioRepo, RolesRepository rolesRepo,
                          UsuarioRolesRepository usuarioRolesRepo,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usuarioRepo = usuarioRepo;
        this.rolesRepo = rolesRepo;
        this.rolesRepo = rolesRepo;
        this.usuarioRolesrepo = usuarioRolesRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    /**
     * Registrar un usuario
     * @param signupRequest
     * @param request
     * @return
     */
    @PostMapping("/registrar")
    public ResponseEntity<?> userSignup(@RequestBody SolicitudRegistro signupRequest, HttpServletRequest request) {
        if (usuarioRepo.existsByEmail(signupRequest.getEmail())) {
            return ResponseEntity.badRequest().body("El Email ya existe");
        }
        Usuarios usuario = new Usuarios();
        usuario.setEmail(signupRequest.getEmail());
        usuario.setNombre(signupRequest.getNombre());
        usuario.setPassword(bCryptPasswordEncoder.encode(signupRequest.getPassword()));
        String[] roleArr = signupRequest.getRoles();
        List<UsuarioRoles> listaRoles = new ArrayList<>();
        //Debe tener al menos un ROL
        if (roleArr == null) {
            return ResponseEntity.badRequest().body("Indique el rol del usuario");
        }
        //Validar cada uno de los roles
        for (String role : roleArr) {
            UsuarioRoles usuarioRol = new UsuarioRoles();
            switch (role) {
                case "admin":
                    usuarioRol.setRolesByRolId(rolesRepo.findById(Autenticacion.ROL_ADMIN));
                    break;
                case "user":
                    usuarioRol.setRolesByRolId(rolesRepo.findById(Autenticacion.ROL_CLIENTE));
                    break;
                default:
                    return ResponseEntity.badRequest().body("El rol indicado no se encuentra registrado");
            }
            if (usuarioRol != null) {
                listaRoles.add(usuarioRol);
            }
        }
        //Crear el usuario si se encontro un rol valido
        if (listaRoles.isEmpty()) {
            return ResponseEntity.badRequest().body("No se encontraron roles validos en la solicitud de registro");
        }
        usuario.setUsuarioRolesById(listaRoles);
        usuario.setFechaHoraCrea(new Timestamp(new Date().getTime()));
        usuario.setTerminalCrea(request.getRemoteAddr());
        usuario.setUsuarioCrea("WebApi");
        usuario = usuarioRepo.saveAndFlush(usuario);
        // Guardar los roles asignados al nuevo usuario
        for (UsuarioRoles usuarioRol : listaRoles){
            usuarioRol.setUsuariosByUsuarioId(usuario);
            usuarioRol.setUsuarioCrea("WebApi");
            usuarioRol.setTerminalCrea(request.getRemoteAddr());
            usuarioRol.setFechaHoraCrea(new Timestamp(new Date().getTime()));
            usuarioRolesrepo.save(usuarioRol);
        }
        return ResponseEntity.ok("Usuario creado con id: " + usuario.getId());
    }

}