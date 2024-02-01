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

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrazione_activity);

        editTextUsername = findViewById(R.id.username);
        editTextPassword = findViewById(R.id.password);
        editTextNome=findViewById(R.id.nome);
        editTextCognome=findViewById(R.id.cognome);

        Button buttonLogin = findViewById(R.id.registrazioneButton);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome= editTextNome.getText().toString();
                String cognome=editTextCognome.getText().toString();
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

                Users nuovoUtente = new Users(nome,cognome,username,password);
                MainActivity.registeredUsers.add(nuovoUtente);
                Intent intent = new Intent(RegistrazioneActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
