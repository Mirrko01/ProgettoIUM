package com.example.visitcagliari;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class DatiPersonali extends AppCompatActivity {
    private TextView editTextUsername, editTextPassword, editTextNome, editTextCognome;
    @SuppressLint("SetTextI18n")
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datipersonali_activity);

       editTextUsername = findViewById(R.id.username);
        editTextNome=findViewById(R.id.nome);
        editTextCognome=findViewById(R.id.cognome);

        editTextNome.setText("Nome: " + MainActivity.loggedUser.nome);
        editTextCognome.setText("Cognome: " + MainActivity.loggedUser.cognome);
        editTextUsername.setText("Username: " + MainActivity.loggedUser.username);
    }
}
