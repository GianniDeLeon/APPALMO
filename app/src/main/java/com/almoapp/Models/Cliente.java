package com.almoapp.Models;
import android.os.Parcel;
import android.os.Parcelable;

public class Cliente implements Parcelable {
    private String nombre;
    private String nit;
    private String direccion;

    public Cliente(String nombre, String nit, String direccion) {
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
    }

    protected Cliente(Parcel in) {
        nombre = in.readString();
        nit = in.readString();
        direccion = in.readString();
    }

    public static final Creator<Cliente> CREATOR = new Creator<Cliente>() {
        @Override
        public Cliente createFromParcel(Parcel in) {
            return new Cliente(in);
        }

        @Override
        public Cliente[] newArray(int size) {
            return new Cliente[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(nit);
        dest.writeString(direccion);
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

