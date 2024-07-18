package com.almoapp.localDB.Controller;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.almoapp.Models.Cliente;
import com.almoapp.localDB.DatabaseHelper;

import java.util.ArrayList;

public class ClientController {
    private DatabaseHelper dbHelper;

    public ClientController(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    // Create
    public boolean insertCliente(int nit, String nombre, String direccion) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nit", nit);
        values.put("nombre", nombre);
        values.put("direccion", direccion);

        long result = db.insert("cliente", null, values);
        return result != -1;
    }

    // Read all clientes
    public ArrayList<Cliente> getAllClientes() {
        ArrayList<Cliente> clienteList = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM cliente", null);
        if (cursor.moveToFirst()) {
            do {
                int nit = cursor.getInt(cursor.getColumnIndexOrThrow("nit"));
                String nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"));
                String direccion = cursor.getString(cursor.getColumnIndexOrThrow("direccion"));
                Cliente cliente = new Cliente(nombre, nit+"", direccion);
                clienteList.add(cliente);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return clienteList;
    }

    public Cursor getClienteByNit(int nit) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        return db.rawQuery("SELECT * FROM cliente WHERE nit = ?", new String[]{String.valueOf(nit)});
    }

    // Update
    public boolean updateCliente(int nit, String nombre, String direccion) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nombre", nombre);
        values.put("direccion", direccion);

        long result = db.update("cliente", values, "nit = ?", new String[]{String.valueOf(nit)});
        return result > 0;
    }

    // Delete
    public boolean deleteCliente(int nit) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        long result = db.delete("cliente", "nit = ?", new String[]{String.valueOf(nit)});
        return result > 0;
    }
}
