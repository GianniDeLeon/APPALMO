package com.almoapp.localDB.Controller;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.almoapp.Models.Producto;
import com.almoapp.localDB.DatabaseHelper;

import java.util.ArrayList;

public class ProductoController {

    private DatabaseHelper dbHelper;

    public ProductoController(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    // Create
    public boolean insertProducto(String nombre, String descripcion, double monto) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nombre", nombre);
        values.put("descripcion", descripcion);
        values.put("monto", monto);

        long result = db.insert("producto", null, values);
        return result != -1;
    }

    // Read
    public ArrayList<Producto> getAllProductos() {
        ArrayList<Producto> productoList = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM producto", null);
        if (cursor.moveToFirst()) {
            do {
                int sku = cursor.getInt(cursor.getColumnIndexOrThrow("sku"));
                String nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"));
                String descripcion = cursor.getString(cursor.getColumnIndexOrThrow("descripcion"));
                String monto = cursor.getString(cursor.getColumnIndexOrThrow("monto"));
                Producto producto = new Producto(sku, nombre, descripcion, monto);
                productoList.add(producto);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return productoList;
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
