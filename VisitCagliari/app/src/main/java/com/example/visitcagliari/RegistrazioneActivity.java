package com.example.visitcagliari;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class RegistrazioneActivity extends AppCompatActivity {

    private EditText editTextUsername, editTextPassword, editTextNome, editTextCognome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrazione_activity);

        editTextUsername = findViewById(R.id.username);
        editTextPassword = findViewById(R.id.password);
        editTextNome = findViewById(R.id.nome);
        editTextCognome = findViewById(R.id.cognome);

        Button buttonRegistrazione = findViewById(R.id.registrazioneButton);
        buttonRegistrazione.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = editTextNome.getText().toString();
                String cognome = editTextCognome.getText().toString();
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

                // Creazione di un nuovo utente
                Users nuovoUtente = new Users(nome, cognome, username, password);

                // Aggiunta del nuovo utente alla lista di utenti registrati
                MainActivity.registeredUsers.add(nuovoUtente);

                // Messaggio di conferma registrazione
                Toast.makeText(RegistrazioneActivity.this, "Registrazione completata", Toast.LENGTH_SHORT).show();

                // Reindirizzamento alla schermata di login
                Intent intent = new Intent(RegistrazioneActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}