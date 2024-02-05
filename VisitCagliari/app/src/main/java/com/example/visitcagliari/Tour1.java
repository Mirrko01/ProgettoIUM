package com.example.visitcagliari;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

public class Tour1 extends AppCompatActivity {
    MaterialCardView card1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tour1_activity);

        // Trova le card
        MaterialCardView card1 = findViewById(R.id.apriItin);

        // Aggiungi il click listener alle card
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDirections();
            }
        });

    }


    private void openDirections() {
        // Sostituisci "LA_TUA_API_KEY" con la tua chiave API di Google Maps
        String apiKey = "AIzaSyD2XQ_-PJvrkNClNwzM5ikH463cxATdH8U";

        // Esempio di itinerario salvato (URL generato da Google Maps)
        String savedDirectionsUrl = "https://maps.app.goo.gl/XtcjwTgRXzb38eQMA";

        // Apri l'itinerario in una nuova finestra del browser
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(savedDirectionsUrl));
        startActivity(intent);
    }
}
