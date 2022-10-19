package com.cdp.agenda.db;

//julianestebanramirezcordoba@gmail.com

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.cdp.agenda.entidades.CLiente;

import java.util.ArrayList;

public class DbCliente extends DbHelper {

    Context context;

    public DbCliente(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarcliente(String nombre, String apellido,String cedula,String telefono, String correo_electronico, String edad,String fechaNacimiento) {

        long id = 0;

        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("cli_nombre", nombre);
            values.put("cli_apelli", apellido);
            values.put("cli_cedula",cedula);
            values.put("cli_telefo", telefono);
            values.put("cli_email", correo_electronico);
            values.put("cli_edad", edad);
            values.put("cli_fechaNacimiento",fechaNacimiento);

            id = db.insert(TABLE_CLIENTE, null, values);

        } catch (Exception ex) {
            ex.toString();
        }

        return id;
    }

    public ArrayList<CLiente> mostrarclientes() {

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<CLiente> listaclientes = new ArrayList<>();
        CLiente cliente;
        Cursor cursorCliente;

        cursorCliente = db.rawQuery("SELECT cli_id,cli_nombre,cli_apelli,cli_cedula,cli_edad,cli_telefo, cli_email,cli_FechaNacimiento  FROM " + TABLE_CLIENTE + " ORDER BY cli_nombre ASC", null);

        while(cursorCliente.moveToNext()) {
                cliente = new CLiente();
                cliente.setId(cursorCliente.getInt(0));
                cliente.setNombre(cursorCliente.getString(1));
                cliente.setApellido(cursorCliente.getString(2));
                cliente.setCedula(cursorCliente.getString(3));
                cliente.setTelefono(cursorCliente.getString(4));
                cliente.setEdad(cursorCliente.getInt(5));
                cliente.setCorreo_electornico(cursorCliente.getString(6));
                cliente.setFechaNacimiento(cursorCliente.getString(7));
                listaclientes.add(cliente);
        }

        cursorCliente.close();
        db.close();
        return listaclientes;
    }

   public void Eliminar(){



   }

}
