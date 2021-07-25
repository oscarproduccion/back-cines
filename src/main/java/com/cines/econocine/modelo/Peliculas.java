package com.cines.econocine.modelo;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Peliculas {
    private int id;
    private String nombreOriginal;
    private String nombreTraduccion;
    private Date fechaEstreno;
    private Date fechaBaja;
    private int duracion;
    private String formato;
    private String rutaImagenPortada;
    private String usuarioCrea;
    private String terminalCrea;
    private Timestamp fechaHoraCrea;
    private String usuarioModifica;
    private String terminalModifica;
    private Timestamp fechaHoraModifica;
    private Collection<PeliculaAgendas> peliculaAgendasById;
    private Collection<PeliculaCamposAdicionales> peliculaCamposAdicionalesById;
    private Collection<PeliculaSucursales> peliculaSucursalesById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nombre_original")
    public String getNombreOriginal() {
        return nombreOriginal;
    }

    public void setNombreOriginal(String nombreOriginal) {
        this.nombreOriginal = nombreOriginal;
    }

    @Basic
    @Column(name = "nombre_traduccion")
    public String getNombreTraduccion() {
        return nombreTraduccion;
    }

    public void setNombreTraduccion(String nombreTraduccion) {
        this.nombreTraduccion = nombreTraduccion;
    }

    @Basic
    @Column(name = "fecha_estreno")
    public Date getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(Date fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    @Basic
    @Column(name = "fecha_baja")
    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    @Basic
    @Column(name = "duracion")
    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Basic
    @Column(name = "formato")
    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    @Basic
    @Column(name = "ruta_imagen_portada")
    public String getRutaImagenPortada() {
        return rutaImagenPortada;
    }

    public void setRutaImagenPortada(String rutaImagenPortada) {
        this.rutaImagenPortada = rutaImagenPortada;
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
        Peliculas peliculas = (Peliculas) o;
        return id == peliculas.id && duracion == peliculas.duracion && Objects.equals(nombreOriginal, peliculas.nombreOriginal) && Objects.equals(nombreTraduccion, peliculas.nombreTraduccion) && Objects.equals(fechaEstreno, peliculas.fechaEstreno) && Objects.equals(fechaBaja, peliculas.fechaBaja) && Objects.equals(formato, peliculas.formato) && Objects.equals(rutaImagenPortada, peliculas.rutaImagenPortada) && Objects.equals(usuarioCrea, peliculas.usuarioCrea) && Objects.equals(terminalCrea, peliculas.terminalCrea) && Objects.equals(fechaHoraCrea, peliculas.fechaHoraCrea) && Objects.equals(usuarioModifica, peliculas.usuarioModifica) && Objects.equals(terminalModifica, peliculas.terminalModifica) && Objects.equals(fechaHoraModifica, peliculas.fechaHoraModifica);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombreOriginal, nombreTraduccion, fechaEstreno, fechaBaja, duracion, formato, rutaImagenPortada, usuarioCrea, terminalCrea, fechaHoraCrea, usuarioModifica, terminalModifica, fechaHoraModifica);
    }

    @OneToMany(mappedBy = "peliculasByPeliculasId")
    public Collection<PeliculaAgendas> getPeliculaAgendasById() {
        return peliculaAgendasById;
    }

    public void setPeliculaAgendasById(Collection<PeliculaAgendas> peliculaAgendasById) {
        this.peliculaAgendasById = peliculaAgendasById;
    }

    @OneToMany(mappedBy = "peliculasByPeliculasId")
    public Collection<PeliculaCamposAdicionales> getPeliculaCamposAdicionalesById() {
        return peliculaCamposAdicionalesById;
    }

    public void setPeliculaCamposAdicionalesById(Collection<PeliculaCamposAdicionales> peliculaCamposAdicionalesById) {
        this.peliculaCamposAdicionalesById = peliculaCamposAdicionalesById;
    }

    @OneToMany(mappedBy = "peliculasByPeliculasId")
    public Collection<PeliculaSucursales> getPeliculaSucursalesById() {
        return peliculaSucursalesById;
    }

    public void setPeliculaSucursalesById(Collection<PeliculaSucursales> peliculaSucursalesById) {
        this.peliculaSucursalesById = peliculaSucursalesById;
    }
}
