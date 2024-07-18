package com.almoapp.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Factura implements Parcelable {
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

    protected Factura(Parcel in) {
        noFactura = in.readString();
        descripcion = in.readString();
        monto = in.readString();
        estado = in.readString();
    }

    public static final Creator<Factura> CREATOR = new Creator<Factura>() {
        @Override
        public Factura createFromParcel(Parcel in) {
            return new Factura(in);
        }

        @Override
        public Factura[] newArray(int size) {
            return new Factura[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(noFactura);
        dest.writeString(descripcion);
        dest.writeString(monto);
        dest.writeString(estado);
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

