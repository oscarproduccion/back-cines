package com.cines.econocine.modelo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Roles {
    private int id;
    private String nombre;
    private String usuarioCrea;
    private String terminalCrea;
    private Timestamp fechaHoraCrea;
    private String usuarioModifica;
    private String terminalModifica;
    private Timestamp fechaHoraModifica;
    private Collection<UsuarioRoles> usuarioRolesById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "usuario_crea")
    public String getUsuarioCrea() {
        return usuarioCrea;
    }

    public void setUsuarioCrea(String usuarioCrea) {
        this.usuarioCrea = usuarioCrea;
    }

    @Basic
    @Column(name = "terminal_crea")
    public String getTerminalCrea() {
        return terminalCrea;
    }

    public void setTerminalCrea(String terminalCrea) {
        this.terminalCrea = terminalCrea;
    }

    @Basic
    @Column(name = "fecha_hora_crea")
    public Timestamp getFechaHoraCrea() {
        return fechaHoraCrea;
    }

    public void setFechaHoraCrea(Timestamp fechaHoraCrea) {
        this.fechaHoraCrea = fechaHoraCrea;
    }

    @Basic
    @Column(name = "usuario_modifica")
    public String getUsuarioModifica() {
        return usuarioModifica;
    }

    public void setUsuarioModifica(String usuarioModifica) {
        this.usuarioModifica = usuarioModifica;
    }

    @Basic
    @Column(name = "terminal_modifica")
    public String getTerminalModifica() {
        return terminalModifica;
    }

    public void setTerminalModifica(String terminalModifica) {
        this.terminalModifica = terminalModifica;
    }

    @Basic
    @Column(name = "fecha_hora_modifica")
    public Timestamp getFechaHoraModifica() {
        return fechaHoraModifica;
    }

    public void setFechaHoraModifica(Timestamp fechaHoraModifica) {
        this.fechaHoraModifica = fechaHoraModifica;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roles roles = (Roles) o;
        return id == roles.id && Objects.equals(nombre, roles.nombre) && Objects.equals(usuarioCrea, roles.usuarioCrea) && Objects.equals(terminalCrea, roles.terminalCrea) && Objects.equals(fechaHoraCrea, roles.fechaHoraCrea) && Objects.equals(usuarioModifica, roles.usuarioModifica) && Objects.equals(terminalModifica, roles.terminalModifica) && Objects.equals(fechaHoraModifica, roles.fechaHoraModifica);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, usuarioCrea, terminalCrea, fechaHoraCrea, usuarioModifica, terminalModifica, fechaHoraModifica);
    }

    @OneToMany(mappedBy = "rolesByRolId")
    public Collection<UsuarioRoles> getUsuarioRolesById() {
        return usuarioRolesById;
    }

    public void setUsuarioRolesById(Collection<UsuarioRoles> usuarioRolesById) {
        this.usuarioRolesById = usuarioRolesById;
    }
}
