package com.edu.unbosque.ch0ch4l1t0.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo_reserva")
public class Tipo_reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String tipo;
    private String descripcion;
    private int precio_tipo_reserva;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio_tipo_reserva() {
        return precio_tipo_reserva;
    }

    public void setPrecio_tipo_reserva(int precio_tipo_reserva) {
        this.precio_tipo_reserva = precio_tipo_reserva;
    }
}
