package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences; // Importa SharedPreferences
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitylogin);

        EditText editTextUsername = findViewById(R.id.editTextUsername);
        EditText editTextPassword = findViewById(R.id.editTextPassword);
        Button buttonLogin = findViewById(R.id.buttonLogin);
        Button buttonRegister = findViewById(R.id.buttonRegister);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredUsername = editTextUsername.getText().toString();
                String enteredPassword = editTextPassword.getText().toString();

                // Obtener las credenciales guardadas con SharedPreferences
                SharedPreferences prefs = getSharedPreferences("UserPrefs", MODE_PRIVATE);
                String savedUsername = prefs.getString("username", "");
                String savedPassword = prefs.getString("password", "");

                if (enteredUsername.equals(savedUsername) && enteredPassword.equals(savedPassword)) {
                    Toast.makeText(loginactivity.this, "Inicio de sesión exitoso!", Toast.LENGTH_SHORT).show();
                    Intent welcomeIntent = new Intent(loginactivity.this, welcomeactivity.class);
                    startActivity(welcomeIntent);
                } else {
                    Toast.makeText(loginactivity.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(loginactivity.this, registroactivity.class);
                startActivity(registerIntent);
            }
        });
    }
}