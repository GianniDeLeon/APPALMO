package com.almoapp.Models;

public class Producto {
    private String nombre;
    private String descripcion;
    private String monto;

    public Producto(String nombre, String descripcion, String monto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.monto = monto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getMonto() {
        return monto;
    }
}
