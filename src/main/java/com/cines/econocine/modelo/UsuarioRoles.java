package com.cines.econocine.modelo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "usuario_roles", schema = "econo_cines", catalog = "")
public class UsuarioRoles {
    private int id;
    private int usuarioId;
    private int rolId;
    private String usuarioCrea;
    private String terminalCrea;
    private Timestamp fechaHoraCrea;
    private Usuarios usuariosByUsuarioId;
    private Roles rolesByRolId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioRoles that = (UsuarioRoles) o;
        return id == that.id && usuarioId == that.usuarioId && rolId == that.rolId && Objects.equals(usuarioCrea, that.usuarioCrea) && Objects.equals(terminalCrea, that.terminalCrea) && Objects.equals(fechaHoraCrea, that.fechaHoraCrea);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usuarioId, rolId, usuarioCrea, terminalCrea, fechaHoraCrea);
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
    @JoinColumn(name = "rol_id", referencedColumnName = "id", nullable = false)
    public Roles getRolesByRolId() {
        return rolesByRolId;
    }

    public void setRolesByRolId(Roles rolesByRolId) {
        this.rolesByRolId = rolesByRolId;
    }
}
