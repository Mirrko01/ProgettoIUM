package com.example.visitcagliari;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Users> registeredUsers=new ArrayList<>();
    public Users prova=new Users("Mirko","Contini","mirko","mirko");
    public static Users loggedUser;
    private EditText editTextUsername, editTextPassword;
    ImageView undo;
    TextView redirectRegistrazione;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registeredUsers.add(prova);
        int x=registeredUsers.size();

        editTextUsername = findViewById(R.id.username);
        editTextPassword = findViewById(R.id.password);
        redirectRegistrazione=findViewById(R.id.registrazioneRedirect);
        undo=findViewById(R.id.undo);

        redirectRegistrazione.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegistrazioneActivity.class);
                startActivity(intent);
            }
        });

        undo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
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
                }
            }
        });
    }

    private boolean authenticate(String username, String password) {
        boolean foundUser = false;

        for (Users utente : registeredUsers) {
            if (utente.username.equals(username)) {
                foundUser = true;
                if (utente.password.equals(password)) {
                    loggedUser = utente;
                    return true; // Login riuscito
                } else {
                    editTextPassword.setError("Password errata!");
                    return false; // Password errata
                }
            }
        }
        if (!foundUser) {
            editTextUsername.setError("Username errato!");
        }
        return false; // Utente non trovato
    }
}