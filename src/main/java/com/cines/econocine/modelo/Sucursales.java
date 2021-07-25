package com.cines.econocine.modelo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Sucursales {
    private int id;
    private String nombre;
    private String direccion;
    private String administrador;
    private int ciudadesId;
    private String usuarioCrea;
    private String terminalCrea;
    private Timestamp fechaHoraCrea;
    private String usuarioModifica;
    private String terminalModifica;
    private Timestamp fechaHoraModifica;
    private Collection<PeliculaAgendas> peliculaAgendasById;
    private Collection<PeliculaSucursales> peliculaSucursalesById;
    private Collection<Salas> salasById;
    private Ciudades ciudadesByCiudadesId;

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
    @Column(name = "direccion")
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Basic
    @Column(name = "administrador")
    public String getAdministrador() {
        return administrador;
    }

    public void setAdministrador(String administrador) {
        this.administrador = administrador;
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
        Sucursales that = (Sucursales) o;
        return id == that.id && administrador == that.administrador && ciudadesId == that.ciudadesId && Objects.equals(nombre, that.nombre) && Objects.equals(direccion, that.direccion) && Objects.equals(usuarioCrea, that.usuarioCrea) && Objects.equals(terminalCrea, that.terminalCrea) && Objects.equals(fechaHoraCrea, that.fechaHoraCrea) && Objects.equals(usuarioModifica, that.usuarioModifica) && Objects.equals(terminalModifica, that.terminalModifica) && Objects.equals(fechaHoraModifica, that.fechaHoraModifica);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, direccion, administrador, ciudadesId, usuarioCrea, terminalCrea, fechaHoraCrea, usuarioModifica, terminalModifica, fechaHoraModifica);
    }

    @OneToMany(mappedBy = "sucursalesBySucursalesId")
    public Collection<PeliculaAgendas> getPeliculaAgendasById() {
        return peliculaAgendasById;
    }

    public void setPeliculaAgendasById(Collection<PeliculaAgendas> peliculaAgendasById) {
        this.peliculaAgendasById = peliculaAgendasById;
    }

    @OneToMany(mappedBy = "sucursalesBySucursalesId")
    public Collection<PeliculaSucursales> getPeliculaSucursalesById() {
        return peliculaSucursalesById;
    }

    public void setPeliculaSucursalesById(Collection<PeliculaSucursales> peliculaSucursalesById) {
        this.peliculaSucursalesById = peliculaSucursalesById;
    }

    @OneToMany(mappedBy = "sucursalesBySucursalesId")
    public Collection<Salas> getSalasById() {
        return salasById;
    }

    public void setSalasById(Collection<Salas> salasById) {
        this.salasById = salasById;
    }

    @ManyToOne
    @JoinColumn(name = "ciudades_id", referencedColumnName = "id", nullable = false)
    public Ciudades getCiudadesByCiudadesId() {
        return ciudadesByCiudadesId;
    }

    public void setCiudadesByCiudadesId(Ciudades ciudadesByCiudadesId) {
        this.ciudadesByCiudadesId = ciudadesByCiudadesId;
    }
}
