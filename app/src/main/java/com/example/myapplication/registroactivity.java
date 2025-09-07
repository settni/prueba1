package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registroactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityregistro);

        // Enlazar los campos del formulario de registro
        EditText etRut = findViewById(R.id.etRut);
        EditText etNombre = findViewById(R.id.etNombre);
        EditText etApellidoPaterno = findViewById(R.id.etApellidoPaterno);
        EditText etApellidoMaterno = findViewById(R.id.etApellidoMaterno);
        EditText etEdad = findViewById(R.id.etEdad);
        EditText etTelefono = findViewById(R.id.etTelefono);
        EditText etDireccion = findViewById(R.id.etDireccion);
        EditText etCorreo = findViewById(R.id.etCorreo);
        EditText etUsuario = findViewById(R.id.usuario);
        EditText etContrasena = findViewById(R.id.contrasena);
        Button btnRegistrar = findViewById(R.id.btnRegistrar);

        btnRegistrar.setOnClickListener(v -> {
            // Guardar el nombre de usuario y contraseña en SharedPreferences
            SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("username", etUsuario.getText().toString());
            editor.putString("password", etContrasena.getText().toString());
            editor.apply();

            // Mensaje de confirmación
            Toast.makeText(this, "Usuario registrado con éxito!", Toast.LENGTH_SHORT).show();

            // Volver a la pantalla de login
            finish();
        });
    }
}