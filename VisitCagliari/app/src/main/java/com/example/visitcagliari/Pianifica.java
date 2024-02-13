package com.example.visitcagliari;

// MainActivity.java
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

public class Pianifica extends AppCompatActivity {

    private Spinner spinnerTime;
    private Spinner spinnerTransportation;
    private Button buttonSubmit;
    GoogleMap gmap;
    FrameLayout map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pianifica_activity);

        WebView webView;
        ImageView undo=findViewById(R.id.undo);
        spinnerTime = findViewById(R.id.spinnerTime);
        spinnerTransportation = findViewById(R.id.spinnerTransportation);
        buttonSubmit = findViewById(R.id.buttonSubmit);


        webView = findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true); // Abilita JavaScript se necessario
        webView.setWebViewClient(new WebViewClient()); // Gestione delle richieste di caricamento della WebView

        // Carica l'URL della mappa
        String mapUrl = "https://www.google.com/maps/d/u/0/embed?mid=1rsF07ojBQ1eD_PRISxG15KQKvS7iLCM&ehbc=2E312F&noprof=1";
        webView.loadUrl(mapUrl);

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


        undo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Pianifica.this, ListaCategorieActivity.class);
                startActivity(intent);
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

        Spinner spinnerPosition = findViewById(R.id.spinnerPosition);
        String position = spinnerPosition.getSelectedItem().toString(); // Ottieni il tempo come stringa

// Estrai il tempo effettivo dalla stringa
        int time;
        if (timeString.startsWith("Meno di")) {
            time = 30; // Se è "Meno di 30 minuti", imposta il tempo a 30 minuti
        } else if (timeString.startsWith("Da 30 minuti")) {
            time = 45; // Se è "Da 30 minuti a 1 ora", imposta il tempo a 45 minuti (la media del range)
        } else if(timeString.startsWith("Da 1 a")){
            time = 90; // Se è "Da 1 a 2 ore", imposta il tempo a 90 minuti (la media del range)
        }
        else{
            time=0;
        }
        if(time==0 && position.startsWith("In che zona") && transportation.startsWith("Come ti sposterai")){
            showConfirmationDialog();
            return;
        }

// Esegui il controllo del trasporto e apri l'intento corrispondente
        if (position.equals("Zona rossa")) {
            if ("A piedi".equals(transportation)) {
                if (time == 30) {
                    intent = new Intent(Pianifica.this, Tour1.class); //GIRO BREVE A CASTELLO, GIRO BREVE DELLE CHIESE DI CASTELLO
                } else if (time == 45) {
                    intent = new Intent(Pianifica.this, Tour2.class); // GIRO MEDIO A CASTELLO, GIRO MEDIO DELLE CHIESE DI CASTELLO
                } else {
                    intent = new Intent(Pianifica.this, Tour3.class); //GIRO COMPLETO DI CASTELLO, GIRO DEI MUSEI
                }
            } else{
                if (time == 30) {
                    intent = new Intent(Pianifica.this, Tour4.class); // GIRO BREVE A CASTELLO, GIRO BREVE DELLE CHIESE DI CASTELLO
                } else if (time == 45) {
                    intent = new Intent(Pianifica.this, Tour5.class); //GIRO MEDIO A CASTELLO,GIRO MEDIO DELLE CHIESE DI CASTELLO
                } else {
                    intent = new Intent(Pianifica.this, Tour6.class); // GIRO COMPLETO DI CASTELLO, GIRO COMPLETO DELLE CHIESE DI CASTELLO, DA CASTELLO A MONTE CLARO
                }
            }
        } else if (position.equals("Zona gialla")) {
            if ("A piedi".equals(transportation)) {
                if (time == 30) {
                    intent = new Intent(Pianifica.this, Tour7.class); //GIRO BREVE DI VILLANOVA
                } else if (time == 45) {
                    intent = new Intent(Pianifica.this, Tour8.class); //GIRO LUNGO DI VILLANOVA
                } else {
                    intent = new Intent(Pianifica.this, Tour9.class); //GIRO DELLE CHIESE DI CASTELLO E VILLANOVA
                }
            } else  {
                if (time == 30) {
                    intent = new Intent(Pianifica.this, Tour10.class); // GIRO BREVE DI VILLANOVA
                } else if (time == 45) {
                    intent = new Intent(Pianifica.this, Tour11.class); //GIRO DI VILLANOVA E AI GIARDINI PUBBLICI
                } else {
                    intent = new Intent(Pianifica.this, Tour12.class); //GIRO PER VILLANOVA E PARCO DI MONTE URPINU
                }
            }
        } else if (position.equals("Zona arancione")) {
            if ("A piedi".equals(transportation)) {
                if (time == 30) {
                    intent = new Intent(Pianifica.this, Tour13.class); //GIRO BREVE DELLE CHIESE DI STAMPACE, GIRO STORICO BREVE DI STAMPACE
                } else if (time == 45) {
                    intent = new Intent(Pianifica.this, Tour14.class); //GIRO INTERMEDIO DELLE CHIESE DI STAMPACE, GIRO STORICO INTERMEDIO DI STAMPACE
                } else {
                    intent = new Intent(Pianifica.this, Tour15.class); //GIRO COMPLETO DI STAMPACE E DELLE VIE DELLA MARINA
                }
            } else {
                if (time == 30) {
                    intent = new Intent(Pianifica.this, Tour16.class); //GIRO IN BICI AL PORTO
                } else if (time == 45) {
                    intent = new Intent(Pianifica.this, Tour17.class); //GIRO INTERMEDIO DELLE CHIESE DI STAMPACE, GIRO COMPLETO DI STAMPACE
                } else {
                    intent = new Intent(Pianifica.this, Tour18.class); //GIRO AL CENTRO DI CAGLIARI
                }
            }
        } else {
            if ("A piedi".equals(transportation)) {
                if (time == 30) {
                    intent = new Intent(Pianifica.this, Tour19.class); //GIRO BREVE ALLA MARINA
                } else if (time == 45) {
                    intent = new Intent(Pianifica.this, Tour20.class); //GIRO DELLE CHIESE DELLA MARINA
                } else {
                    intent = new Intent(Pianifica.this, Tour21.class); //DA VIA ROMA A PIAZZA YENNE PASSANDO PER LA MARINA
                }
            } else {
                if (time == 30) {
                    intent = new Intent(Pianifica.this, Tour22.class); //GIRO BREVE ALLA MARINA
                } else if (time == 45) {
                    intent = new Intent(Pianifica.this, Tour23.class); //GIRO DELLE CHIESE DELLA MARINA
                } else {
                    intent = new Intent(Pianifica.this, Tour24.class); //GIRO LUNGO AL CENTRO DI CAGLIARI
                }
            }
        }

// Avvia l'attività corrispondente
        startActivity(intent);
    }

    private void showConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Devi dare un valore a tutti i campi!");
        builder.setPositiveButton("Va bene", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }


}
