package com.almoapp.localDB.Controller;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.almoapp.Models.Factura;
import com.almoapp.localDB.DatabaseHelper;

import java.util.ArrayList;

public class FacturaController {

    private DatabaseHelper dbHelper;

    public FacturaController(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    // Create
    public boolean insertFactura( String descripcion, String monto, int estado) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("descripcion", descripcion);
        values.put("monto", monto);
        values.put("estado", estado);

        long result = db.insert("factura", null, values);
        return result != -1;
    }

    // Read
    public ArrayList<Factura> getAllFacturas() {
        ArrayList<Factura> facturaList = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM factura", null);
        if (cursor.moveToFirst()) {
            do {
                String noFactura = cursor.getString(cursor.getColumnIndexOrThrow("noFactura"));
                String descripcion = cursor.getString(cursor.getColumnIndexOrThrow("descripcion"));
                String monto = cursor.getString(cursor.getColumnIndexOrThrow("monto"));
                String estado = cursor.getString(cursor.getColumnIndexOrThrow("estado"));
                Factura factura = new Factura(noFactura, descripcion, monto, estado);
                facturaList.add(factura);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return facturaList;
    }

    public Cursor getFacturaByNoFactura(int noFactura) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        return db.rawQuery("SELECT * FROM factura WHERE noFactura = ?", new String[]{String.valueOf(noFactura)});
    }

    // Update
    public boolean updateFactura(int noFactura, String descripcion, String monto, int estado) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("descripcion", descripcion);
        values.put("monto", monto);
        values.put("estado", estado);

        long result = db.update("factura", values, "noFactura = ?", new String[]{String.valueOf(noFactura)});
        return result > 0;
    }

    // Delete
    public boolean deleteFactura(int noFactura) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        long result = db.delete("factura", "noFactura = ?", new String[]{String.valueOf(noFactura)});
        return result > 0;
    }
}
