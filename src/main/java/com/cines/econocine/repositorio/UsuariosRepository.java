package com.cines.econocine.repositorio;

import com.cines.econocine.modelo.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {
    public Usuarios findByEmail(String email);
    public boolean existsByEmail(String email);

    @Query(value="SELECT id, email, nombre, " +
            "DATE_FORMAT(fecha_hora_crea, '%Y/%m/%d %H:%i') as fechaHoraCrea, " +
            "terminal_crea as terminalCrea," +
            "usuario_crea as usuarioCrea " +
            "FROM Usuarios", nativeQuery=true)
    List<IUsuarios> findAllBy();

    /**
     * IFace Usuarios Publico
     */
    interface IUsuarios {
        Long getId();
        String getEmail();
        String getNombre();
        String getFechaHoraCrea();
        String getTerminalCrea();
        String getUsuarioCrea();
    }

}