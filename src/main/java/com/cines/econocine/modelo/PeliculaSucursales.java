package com.cines.econocine.modelo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "pelicula_sucursales", schema = "econo_cines", catalog = "")
public class PeliculaSucursales {
    private int id;
    private int peliculasId;
    private Integer sucursalesId;
    private String usuarioCrea;
    private String terminalCrea;
    private Timestamp fechaHoraCrea;
    private String usuarioModifica;
    private String terminalModifica;
    private Timestamp fechaHoraModifica;
    private Peliculas peliculasByPeliculasId;
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
        PeliculaSucursales that = (PeliculaSucursales) o;
        return id == that.id && peliculasId == that.peliculasId && Objects.equals(sucursalesId, that.sucursalesId) && Objects.equals(usuarioCrea, that.usuarioCrea) && Objects.equals(terminalCrea, that.terminalCrea) && Objects.equals(fechaHoraCrea, that.fechaHoraCrea) && Objects.equals(usuarioModifica, that.usuarioModifica) && Objects.equals(terminalModifica, that.terminalModifica) && Objects.equals(fechaHoraModifica, that.fechaHoraModifica);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, peliculasId, sucursalesId, usuarioCrea, terminalCrea, fechaHoraCrea, usuarioModifica, terminalModifica, fechaHoraModifica);
    }

    @ManyToOne
    @JoinColumn(name = "peliculas_id", referencedColumnName = "id", nullable = false)
    public Peliculas getPeliculasByPeliculasId() {
        return peliculasByPeliculasId;
    }

    public void setPeliculasByPeliculasId(Peliculas peliculasByPeliculasId) {
        this.peliculasByPeliculasId = peliculasByPeliculasId;
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
