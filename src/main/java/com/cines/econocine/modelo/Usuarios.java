package com.cines.econocine.modelo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Usuarios {
    private int id;
    private String nombre;
    private String email;
    private String password;
    private String usuarioCrea;
    private String terminalCrea;
    private Timestamp fechaHoraCrea;
    private String usuarioModifica;
    private String terminalModifica;
    private Timestamp fechaHoraModifica;
    private Collection<SalaReservas> salaReservasById;
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
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        Usuarios usuarios = (Usuarios) o;
        return id == usuarios.id && Objects.equals(nombre, usuarios.nombre) && Objects.equals(email, usuarios.email) && Objects.equals(password, usuarios.password) && Objects.equals(usuarioCrea, usuarios.usuarioCrea) && Objects.equals(terminalCrea, usuarios.terminalCrea) && Objects.equals(fechaHoraCrea, usuarios.fechaHoraCrea) && Objects.equals(usuarioModifica, usuarios.usuarioModifica) && Objects.equals(terminalModifica, usuarios.terminalModifica) && Objects.equals(fechaHoraModifica, usuarios.fechaHoraModifica);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, email, password, usuarioCrea, terminalCrea, fechaHoraCrea, usuarioModifica, terminalModifica, fechaHoraModifica);
    }

    @OneToMany(mappedBy = "usuariosByUsuarioId")
    public Collection<SalaReservas> getSalaReservasById() {
        return salaReservasById;
    }

    public void setSalaReservasById(Collection<SalaReservas> salaReservasById) {
        this.salaReservasById = salaReservasById;
    }

    @OneToMany(mappedBy = "usuariosByUsuarioId")
    public Collection<UsuarioRoles> getUsuarioRolesById() {
        return usuarioRolesById;
    }

    public void setUsuarioRolesById(Collection<UsuarioRoles> usuarioRolesById) {
        this.usuarioRolesById = usuarioRolesById;
    }
}
