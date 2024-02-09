package com.example.visitcagliari;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

public class Tour8 extends AppCompatActivity {
    MaterialCardView card1;
    MaterialCardView card2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tour8_activity);

        // Trova le card
        card1 = findViewById(R.id.tour8_1);
        card2 = findViewById(R.id.tour8_2);

        // Aggiungi il click listener alle card
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDirections("https://maps.app.goo.gl/XtcjwTgRXzb38eQMA");
            }
        });

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDirections("https://maps.app.goo.gl/XtcjwTgRXzb38eQMA");
            }
        });

    }


    private void openDirections(String url) {
        // Sostituisci "LA_TUA_API_KEY" con la tua chiave API di Google Maps
        String apiKey = "AIzaSyD2XQ_-PJvrkNClNwzM5ikH463cxATdH8U";
        // Apri l'itinerario in una nuova finestra del browser
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}
