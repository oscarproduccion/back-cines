package com.cines.econocine.modelo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Salas {
    private int id;
    private String nombre;
    private int tipoSalaId;
    private int numeroFilas;
    private int numeroSillasFila;
    private Integer sucursalesId;
    private String usuarioCrea;
    private String terminalCrea;
    private Timestamp fechaHoraCrea;
    private String usuarioModifica;
    private String terminalModifica;
    private Timestamp fechaHoraModifica;
    private Collection<SalaReservas> salaReservasById;
    private SalaTipos salaTiposByTipoSalaId;
    private Sucursales sucursalesBySucursalesId;

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
    @Column(name = "numero_filas")
    public int getNumeroFilas() {
        return numeroFilas;
    }

    public void setNumeroFilas(int numeroFilas) {
        this.numeroFilas = numeroFilas;
    }

    @Basic
    @Column(name = "numero_sillas_fila")
    public int getNumeroSillasFila() {
        return numeroSillasFila;
    }

    public void setNumeroSillasFila(int numeroSillasFila) {
        this.numeroSillasFila = numeroSillasFila;
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
        Salas salas = (Salas) o;
        return id == salas.id && tipoSalaId == salas.tipoSalaId && numeroFilas == salas.numeroFilas && numeroSillasFila == salas.numeroSillasFila && Objects.equals(nombre, salas.nombre) && Objects.equals(sucursalesId, salas.sucursalesId) && Objects.equals(usuarioCrea, salas.usuarioCrea) && Objects.equals(terminalCrea, salas.terminalCrea) && Objects.equals(fechaHoraCrea, salas.fechaHoraCrea) && Objects.equals(usuarioModifica, salas.usuarioModifica) && Objects.equals(terminalModifica, salas.terminalModifica) && Objects.equals(fechaHoraModifica, salas.fechaHoraModifica);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, tipoSalaId, numeroFilas, numeroSillasFila, sucursalesId, usuarioCrea, terminalCrea, fechaHoraCrea, usuarioModifica, terminalModifica, fechaHoraModifica);
    }

    @OneToMany(mappedBy = "salasBySalasId")
    public Collection<SalaReservas> getSalaReservasById() {
        return salaReservasById;
    }

    public void setSalaReservasById(Collection<SalaReservas> salaReservasById) {
        this.salaReservasById = salaReservasById;
    }

    @ManyToOne
    @JoinColumn(name = "tipo_sala_id", referencedColumnName = "id", nullable = false)
    public SalaTipos getSalaTiposByTipoSalaId() {
        return salaTiposByTipoSalaId;
    }

    public void setSalaTiposByTipoSalaId(SalaTipos salaTiposByTipoSalaId) {
        this.salaTiposByTipoSalaId = salaTiposByTipoSalaId;
    }

    @ManyToOne
    @JoinColumn(name = "sucursales_id", referencedColumnName = "id")
    public Sucursales getSucursalesBySucursalesId() {
        return sucursalesBySucursalesId;
    }

    public void setSucursalesBySucursalesId(Sucursales sucursalesBySucursalesId) {
        this.sucursalesBySucursalesId = sucursalesBySucursalesId;
    }
}
