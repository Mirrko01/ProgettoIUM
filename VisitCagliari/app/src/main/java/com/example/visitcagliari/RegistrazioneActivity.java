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
import java.util.regex.Pattern;

public class RegistrazioneActivity extends AppCompatActivity {

    private EditText editTextUsername, editTextPassword, editTextNome, editTextCognome, confermPSW;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrazione_activity);

        editTextUsername = findViewById(R.id.username);
        editTextPassword = findViewById(R.id.password);
        editTextNome = findViewById(R.id.nome);
        editTextCognome = findViewById(R.id.cognome);
        confermPSW=findViewById(R.id.confermaPassword);

        Button buttonRegistrazione = findViewById(R.id.registrazioneButton);
        buttonRegistrazione.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = editTextNome.getText().toString();
                String cognome = editTextCognome.getText().toString();
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();
                String conferma= confermPSW.getText().toString();


                if(!isStringPulita(nome)){
                    editTextNome.setError("Il nome non può essere vuoto e non può contenere numeri");
                    editTextNome.setText("");
                }
                else if(!isStringPulita(cognome)){
                    editTextCognome.setError("Il cognome non può essere vuoto e non può contenere numeri");
                    editTextCognome.setText("");
                }
                else if(!isStringPulita(username)){
                    editTextUsername.setError("Lo username non può essere vuoto e non può contenere numeri");
                }
                else if(!password.equals(conferma)){
                    editTextPassword.setError("Le due password non sono uguali");
                    editTextPassword.setText("");
                    confermPSW.setText("");
                }
                else{
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
            }
        });
    }

    public static boolean isStringPulita(String input) {
        // Verifica che la stringa non sia vuota
        if (input.isEmpty()) {
            return false;
        }

        // Definisci l'espressione regolare per controllare che la stringa contenga solo lettere minuscole e maiuscole
        String regex = "^[a-zA-Z]+$";

        // Compila il pattern regex
        Pattern pattern = Pattern.compile(regex);

        // Effettua il match della stringa con il pattern regex
        return pattern.matcher(input).matches();
    }
}