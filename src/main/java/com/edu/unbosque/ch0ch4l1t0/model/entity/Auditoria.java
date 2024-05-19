package com.edu.unbosque.ch0ch4l1t0.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "auditoria")
public class Auditoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String accion;
    private String tabla_afectada;
    private String detalle_accion;
    private Timestamp fecha;

    @ManyToOne
    @JoinColumn(name = "dni_usuario")
    private Usuario usuario;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getTabla_afectada() {
        return tabla_afectada;
    }

    public void setTabla_afectada(String tabla_afectada) {
        this.tabla_afectada = tabla_afectada;
    }

    public String getDetalle_accion() {
        return detalle_accion;
    }

    public void setDetalleAccion(String detalle_accion) {
        this.detalle_accion = detalle_accion;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
