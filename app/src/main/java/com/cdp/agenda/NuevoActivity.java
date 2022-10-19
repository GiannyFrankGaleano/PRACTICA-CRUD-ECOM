package com.cdp.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cdp.agenda.db.DbCliente;

public class NuevoActivity extends AppCompatActivity {

    public TextView viewCedula, viewNombre,viewApellido,viewTelefono;
    public EditText txtNombre,txtCedula,txtApellido, txtTelefono, txtCorreoElectronico, txtEdad,txtFechaNacimiento;
    public Button btnGuarda;
    public String html ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);

        viewCedula = findViewById(R.id.viewCedula);
        txtCedula = findViewById(R.id.txtCedula);
        viewNombre = findViewById(R.id.viewNombre);
        viewApellido = findViewById(R.id.viewApellido);
        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        viewTelefono = findViewById(R.id.viewTelefono);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtEdad = findViewById(R.id.txtEdad);
        txtFechaNacimiento = findViewById(R.id.txtfecha_nacimiento);

        txtCorreoElectronico = findViewById(R.id.txtCorreoElectronico);

        btnGuarda = findViewById(R.id.btnGuarda);

        html = "<span style='color:red;'>*</span>";

        viewCedula.setText(Html.fromHtml(viewCedula.getText().toString()+html));
        viewNombre.setText(Html.fromHtml(viewNombre.getText().toString()+html));
        viewTelefono.setText(Html.fromHtml(viewTelefono.getText().toString()+html));
        viewApellido.setText(Html.fromHtml(viewApellido.getText().toString()+html));


        btnGuarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!txtCedula.getText().toString().equals("") && !txtNombre.getText().toString().equals("") && !txtTelefono.getText().toString().equals("") && !txtApellido.getText().toString().equals("")) {
                    DbCliente dbclientes = new DbCliente(NuevoActivity.this);
                    long id = dbclientes.insertarcliente(txtNombre.getText().toString(),txtApellido.getText().toString(),txtCedula.getText().toString(), txtTelefono.getText().toString(), txtCorreoElectronico.getText().toString(), txtEdad.getText().toString(),txtFechaNacimiento.getText().toString());
                    if (id > 0) {
                        Toast.makeText(NuevoActivity.this, "REGISTRO GUARDADO", Toast.LENGTH_LONG).show();
                        limpiar();
                    } else {
                        Toast.makeText(NuevoActivity.this, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(NuevoActivity.this, "DEBE LLENAR LOS CAMPOS OBLIGATORIOS", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void limpiar() {
        setResult(RESULT_OK);
        finish();
        txtCedula.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtTelefono.setText("");
        txtCorreoElectronico.setText("");
        txtEdad.setText("");
        txtFechaNacimiento.setText("");
    }
}