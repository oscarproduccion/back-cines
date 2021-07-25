package com.cines.econocine.modelo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "sala_reservas", schema = "econo_cines", catalog = "")
public class SalaReservas {
    private int id;
    private int salasId;
    private Timestamp fechaHoraAgenda;
    private int fila;
    private int silla;
    private int usuarioId;
    private BigDecimal valorPago;
    private boolean pagado;
    private Timestamp fechaHoraPago;
    private String usuarioCrea;
    private String terminalCrea;
    private Timestamp fechaHoraCrea;
    private String usuarioModifica;
    private String terminalModifica;
    private Timestamp fechaHoraModifica;
    private Salas salasBySalasId;
    private Usuarios usuariosByUsuarioId;
    private PeliculaAgendas peliculaAgendasByPeliculaAgendasId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "fecha_hora_agenda")
    public Timestamp getFechaHoraAgenda() {
        return fechaHoraAgenda;
    }

    public void setFechaHoraAgenda(Timestamp fechaHoraAgenda) {
        this.fechaHoraAgenda = fechaHoraAgenda;
    }

    @Basic
    @Column(name = "fila")
    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    @Basic
    @Column(name = "silla")
    public int getSilla() {
        return silla;
    }

    public void setSilla(int silla) {
        this.silla = silla;
    }

    @Basic
    @Column(name = "valor_pago")
    public BigDecimal getValorPago() {
        return valorPago;
    }

    public void setValorPago(BigDecimal valorPago) {
        this.valorPago = valorPago;
    }

    @Basic
    @Column(name = "pagado")
    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    @Basic
    @Column(name = "fecha_hora_pago")
    public Timestamp getFechaHoraPago() {
        return fechaHoraPago;
    }

    public void setFechaHoraPago(Timestamp fechaHoraPago) {
        this.fechaHoraPago = fechaHoraPago;
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
        SalaReservas that = (SalaReservas) o;
        return id == that.id && salasId == that.salasId && fila == that.fila && silla == that.silla && usuarioId == that.usuarioId && pagado == that.pagado && Objects.equals(fechaHoraAgenda, that.fechaHoraAgenda) && Objects.equals(valorPago, that.valorPago) && Objects.equals(fechaHoraPago, that.fechaHoraPago) && Objects.equals(usuarioCrea, that.usuarioCrea) && Objects.equals(terminalCrea, that.terminalCrea) && Objects.equals(fechaHoraCrea, that.fechaHoraCrea) && Objects.equals(usuarioModifica, that.usuarioModifica) && Objects.equals(terminalModifica, that.terminalModifica) && Objects.equals(fechaHoraModifica, that.fechaHoraModifica);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, salasId, fechaHoraAgenda, fila, silla, usuarioId, valorPago, pagado, fechaHoraPago, usuarioCrea, terminalCrea, fechaHoraCrea, usuarioModifica, terminalModifica, fechaHoraModifica);
    }

    @ManyToOne
    @JoinColumn(name = "salas_id", referencedColumnName = "id", nullable = false)
    public Salas getSalasBySalasId() {
        return salasBySalasId;
    }

    public void setSalasBySalasId(Salas salasBySalasId) {
        this.salasBySalasId = salasBySalasId;
    }

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false)
    public Usuarios getUsuariosByUsuarioId() {
        return usuariosByUsuarioId;
    }

    public void setUsuariosByUsuarioId(Usuarios usuariosByUsuarioId) {
        this.usuariosByUsuarioId = usuariosByUsuarioId;
    }

    @ManyToOne
    @JoinColumn(name = "pelicula_agendas_id", referencedColumnName = "id", nullable = false)
    public PeliculaAgendas getPeliculaAgendasByPeliculaAgendasId() {
        return peliculaAgendasByPeliculaAgendasId;
    }

    public void setPeliculaAgendasByPeliculaAgendasId(PeliculaAgendas peliculaAgendasByPeliculaAgendasId) {
        this.peliculaAgendasByPeliculaAgendasId = peliculaAgendasByPeliculaAgendasId;
    }

}
