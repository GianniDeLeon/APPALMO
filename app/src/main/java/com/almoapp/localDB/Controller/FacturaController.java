package com.almoapp.localDB.Controller;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.almoapp.localDB.DatabaseHelper;

public class FacturaController {

    private DatabaseHelper dbHelper;

    public FacturaController(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    // Create
    public boolean insertFactura(int noFactura, String descripcion, String monto, int estado) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("noFactura", noFactura);
        values.put("descripcion", descripcion);
        values.put("monto", monto);
        values.put("estado", estado);

        long result = db.insert("factura", null, values);
        return result != -1;
    }

    // Read
    public Cursor getAllFacturas() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        return db.rawQuery("SELECT * FROM factura", null);
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
