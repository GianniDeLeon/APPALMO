package com.almoapp.localDB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "mydb.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createClienteTable = "CREATE TABLE cliente (" +
                "nit INTEGER PRIMARY KEY," +
                "nombre TEXT NOT NULL," +
                "direccion TEXT NOT NULL" +
                ");";

        String createProductoTable = "CREATE TABLE producto (" +
                "sku INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "descripcion TEXT NOT NULL," +
                "monto REAL NOT NULL" +
                ");";

        String createFacturaTable = "CREATE TABLE factura (" +
                "noFactura INTEGER PRIMARY KEY," +
                "descripcion TEXT NOT NULL," +
                "monto TEXT NOT NULL," +
                "estado INTEGER NOT NULL DEFAULT 1" +
                ");";

        String createFacturaDetalleTable = "CREATE TABLE facturaDetalle (" +
                "idfacturaDetalle INTEGER NOT NULL," +
                "cliente_nit INTEGER NOT NULL," +
                "producto_sku INTEGER NOT NULL," +
                "factura_noFactura INTEGER NOT NULL," +
                "PRIMARY KEY (idfacturaDetalle, cliente_nit, producto_sku, factura_noFactura)," +
                "FOREIGN KEY (cliente_nit) REFERENCES cliente(nit)," +
                "FOREIGN KEY (producto_sku) REFERENCES producto(sku)," +
                "FOREIGN KEY (factura_noFactura) REFERENCES factura(noFactura)" +
                ");";

        db.execSQL(createClienteTable);
        db.execSQL(createProductoTable);
        db.execSQL(createFacturaTable);
        db.execSQL(createFacturaDetalleTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS facturaDetalle");
        db.execSQL("DROP TABLE IF EXISTS factura");
        db.execSQL("DROP TABLE IF EXISTS producto");
        db.execSQL("DROP TABLE IF EXISTS cliente");
        onCreate(db);
    }
}
