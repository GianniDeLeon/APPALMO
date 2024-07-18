package com.almoapp.localDB.Controller;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.almoapp.localDB.DatabaseHelper;

public class FacturaDetalleController {

    private DatabaseHelper dbHelper;

    public FacturaDetalleController(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    // Create
    public boolean insertFacturaDetalle(int idfacturaDetalle, int cliente_nit, int producto_sku, int factura_noFactura) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("idfacturaDetalle", idfacturaDetalle);
        values.put("cliente_nit", cliente_nit);
        values.put("producto_sku", producto_sku);
        values.put("factura_noFactura", factura_noFactura);

        long result = db.insert("facturaDetalle", null, values);
        return result != -1;
    }

    // Read
    public Cursor getAllFacturaDetalles() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        return db.rawQuery("SELECT * FROM facturaDetalle", null);
    }

    public Cursor getFacturaDetalleById(int idfacturaDetalle) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        return db.rawQuery("SELECT * FROM facturaDetalle WHERE idfacturaDetalle = ?", new String[]{String.valueOf(idfacturaDetalle)});
    }

    // Update
    public boolean updateFacturaDetalle(int idfacturaDetalle, int cliente_nit, int producto_sku, int factura_noFactura) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("cliente_nit", cliente_nit);
        values.put("producto_sku", producto_sku);
        values.put("factura_noFactura", factura_noFactura);

        long result = db.update("facturaDetalle", values, "idfacturaDetalle = ?", new String[]{String.valueOf(idfacturaDetalle)});
        return result > 0;
    }

    // Delete
    public boolean deleteFacturaDetalle(int idfacturaDetalle) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        long result = db.delete("facturaDetalle", "idfacturaDetalle = ?", new String[]{String.valueOf(idfacturaDetalle)});
        return result > 0;
    }
}
