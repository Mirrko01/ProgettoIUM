package com.example.visitcagliari;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Users> registeredUsers=new ArrayList<>();

    Users prova=new Users("Mirko","Contini","mirko","mirko");
    public static Users loggedUser;
    private EditText editTextUsername, editTextPassword;
    private TextView redirectRegistrazione;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registeredUsers.add(prova);

        editTextUsername = findViewById(R.id.username);
        editTextPassword = findViewById(R.id.password);
        redirectRegistrazione=findViewById(R.id.registrazioneRedirect);

        redirectRegistrazione.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegistrazioneActivity.class);
                startActivity(intent);
            }
        });

        Button buttonLogin = findViewById(R.id.loginButton);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Logica di autenticazione
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

                if (authenticate(username, password)) {
                    // Login riuscito
                    Toast.makeText(MainActivity.this, "Login riuscito", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, ListaCategorieActivity.class);
                    startActivity(intent);
                } else {
                    // Login fallito
                    Toast.makeText(MainActivity.this, "Credenziali non valide", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button map = findViewById(R.id.provaMappa);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ItinerarioActivity.class);
                startActivity(intent);

            }
        });
    }

    private boolean authenticate(String username, String password) {
        for (Users utente : registeredUsers){
            if(!utente.username.equals(username)){
                Toast.makeText(MainActivity.this, "Username errato", Toast.LENGTH_SHORT).show();
                return false;
            }
            else if(!utente.password.equals(password)){
                Toast.makeText(MainActivity.this, "Password errata", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        return true;
    }


}