package com.cdp.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cdp.agenda.db.DbCliente;

public class modificar extends AppCompatActivity {


    EditText nombre;
    EditText apellido;
    EditText celular;
    EditText email;
    Button mody;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);

        mody = findViewById(R.id.modify);
        nombre = findViewById(R.id.nombre);
        apellido = findViewById(R.id.apellido);
        email = findViewById(R.id.TextEmai);
        celular = findViewById(R.id.Phone);



    }
}