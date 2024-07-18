package com.almoapp.Models;
import android.os.Parcel;
import android.os.Parcelable;

public class Producto implements Parcelable {
    private String nombre;
    private String descripcion;
    private String monto;
    private int sku;

    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

    public Producto(String nombre, String descripcion, String monto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.monto = monto;
    }
    public Producto(int sku,String nombre, String descripcion, String monto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.monto = monto;
        this.sku = sku;
    }

    protected Producto(Parcel in) {
        nombre = in.readString();
        descripcion = in.readString();
        monto = in.readDouble();
    }

    public static final Creator<Producto> CREATOR = new Creator<Producto>() {
        @Override
        public Producto createFromParcel(Parcel in) {
            return new Producto(in);
        }

        @Override
        public Producto[] newArray(int size) {
            return new Producto[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(descripcion);
        dest.writeDouble(monto);
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getMonto() {
        return monto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }
}
