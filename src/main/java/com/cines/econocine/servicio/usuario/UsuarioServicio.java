package com.cines.econocine.servicio.usuario;

import com.cines.econocine.modelo.Usuarios;
import com.cines.econocine.repositorio.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;


@Service
public class UsuarioServicio implements UserDetailsService {

    private UsuariosRepository usuarioRepo;

    public UsuarioServicio(UsuariosRepository usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuarios usuario = usuarioRepo.findByEmail(email);
        if (usuario == null) {
            throw new UsernameNotFoundException(email);
        }
        return new User(usuario.getEmail(), usuario.getPassword(), emptyList());
    }

}
