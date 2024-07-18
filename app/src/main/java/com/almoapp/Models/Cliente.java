package com.almoapp.Models;

public class Cliente {
    private String nombre;
    private String nit;
    private String direccion;

    public Cliente(String nombre, String nit, String direccion) {
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNit() {
        return nit;
    }

    public String getDireccion() {
        return direccion;
    }
}
