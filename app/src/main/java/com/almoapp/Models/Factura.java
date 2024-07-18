package com.almoapp.Models;

public class Factura {
    private String noFactura;
    private String descripcion;
    private String monto;
    private String estado;

    public Factura(String noFactura, String descripcion, String monto, String estado) {
        this.noFactura = noFactura;
        this.descripcion = descripcion;
        this.monto = monto;
        this.estado = estado;
    }

    public String getNoFactura() {
        return noFactura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getMonto() {
        return monto;
    }

    public String getEstado() {
        return estado;
    }
}
