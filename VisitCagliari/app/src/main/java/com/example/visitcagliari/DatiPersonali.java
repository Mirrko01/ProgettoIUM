package com.example.visitcagliari;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class DatiPersonali extends AppCompatActivity {
    private TextView editTextUsername, editTextPassword, editTextNome, editTextCognome;
    ImageView undo;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datipersonali_activity);

        undo=findViewById(R.id.undo);
        editTextUsername = findViewById(R.id.username);
        editTextNome= findViewById(R.id.nome);
        editTextCognome= findViewById(R.id.cognome);

        editTextNome.setText("Nome: " + MainActivity.loggedUser.nome);
        editTextCognome.setText("Cognome: " + MainActivity.loggedUser.cognome);
        editTextUsername.setText("Username: " + MainActivity.loggedUser.username);

        undo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DatiPersonali.this, ListaCategorieActivity.class);
                startActivity(intent);
            }
        });
    }
}
