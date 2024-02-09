package com.example.visitcagliari;

// MainActivity.java
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Pianifica extends AppCompatActivity {

    private Spinner spinnerTime;
    private Spinner spinnerTransportation;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pianifica_activity);

        spinnerTime = findViewById(R.id.spinnerTime);
        spinnerTransportation = findViewById(R.id.spinnerTransportation);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        // Populating spinner with transportation options
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(
                this,
                R.array.time_options,
                android.R.layout.simple_spinner_item
        );
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTime.setAdapter(adapter1);

        // Populating spinner with transportation options
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.transportation_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTransportation.setAdapter(adapter);

        // Setting click listener for the button
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateResult();
            }
        });
    }

    private void calculateResult() {
        Intent intent;

// Ottieni il valore selezionato dallo spinner del trasporto
        Spinner spinnerTransportation = findViewById(R.id.spinnerTransportation);
        String transportation = spinnerTransportation.getSelectedItem().toString();

// Ottieni il valore selezionato dallo spinner del tempo
        Spinner spinnerTime = findViewById(R.id.spinnerTime);
        String timeString = spinnerTime.getSelectedItem().toString(); // Ottieni il tempo come stringa

// Estrai il tempo effettivo dalla stringa
        int time;
        if (timeString.startsWith("Meno di")) {
            time = 30; // Se è "Meno di 30 minuti", imposta il tempo a 30 minuti
        } else if (timeString.startsWith("Da 30 minuti")) {
            time = 45; // Se è "Da 30 minuti a 1 ora", imposta il tempo a 45 minuti (la media del range)
        } else  {
            time = 90; // Se è "Da 1 a 2 ore", imposta il tempo a 90 minuti (la media del range)
        }

// Esegui il controllo del trasporto e apri l'intento corrispondente
        if ("A piedi".equals(transportation)) {
            if (time == 30) {
                intent = new Intent(Pianifica.this, Tour1.class); // A piedi e meno di 30 minuti
            } else if (time == 45) {
                intent = new Intent(Pianifica.this, Tour2.class); // A piedi e da 30 minuti a 1 ora
            } else {
                intent = new Intent(Pianifica.this, Tour3.class); // A piedi e da 1 a 2 ore
            }
        } else if ("In bus".equals(transportation)) {
            if (time == 30) {
                intent = new Intent(Pianifica.this, Tour4.class); // A piedi e meno di 30 minuti
            } else if (time == 45) {
                intent = new Intent(Pianifica.this, Tour5.class); // A piedi e da 30 minuti a 1 ora
            } else {
                intent = new Intent(Pianifica.this, Tour6.class); // A piedi e da 1 a 2 ore
            }
        } else  {
            if (time == 30) {
                intent = new Intent(Pianifica.this, Tour7.class); // A piedi e meno di 30 minuti
            } else if (time == 45) {
                intent = new Intent(Pianifica.this, Tour8.class); // A piedi e da 30 minuti a 1 ora
            } else {
                intent = new Intent(Pianifica.this, Tour9.class); // A piedi e da 1 a 2 ore
            }
        }

// Avvia l'attività corrispondente
        startActivity(intent);
    }
}
