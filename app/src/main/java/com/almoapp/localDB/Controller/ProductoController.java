package com.almoapp.localDB.Controller;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.almoapp.localDB.DatabaseHelper;

public class ProductoController {

    private DatabaseHelper dbHelper;

    public ProductoController(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    // Create
    public boolean insertProducto(int sku, String nombre, String descripcion, double monto) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("sku", sku);
        values.put("nombre", nombre);
        values.put("descripcion", descripcion);
        values.put("monto", monto);

        long result = db.insert("producto", null, values);
        return result != -1;
    }

    // Read
    public Cursor getAllProductos() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        return db.rawQuery("SELECT * FROM producto", null);
    }

    public Cursor getProductoBySku(int sku) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        return db.rawQuery("SELECT * FROM producto WHERE sku = ?", new String[]{String.valueOf(sku)});
    }

    // Update
    public boolean updateProducto(int sku, String nombre, String descripcion, double monto) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nombre", nombre);
        values.put("descripcion", descripcion);
        values.put("monto", monto);

        long result = db.update("producto", values, "sku = ?", new String[]{String.valueOf(sku)});
        return result > 0;
    }

    // Delete
    public boolean deleteProducto(int sku) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        long result = db.delete("producto", "sku = ?", new String[]{String.valueOf(sku)});
        return result > 0;
    }
}
