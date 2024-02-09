package com.example.visitcagliari;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

public class Tour3 extends AppCompatActivity {
    MaterialCardView card1;
    MaterialCardView card2;

    ImageView undo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tour3_activity);

        // Trova le card
        card1 = findViewById(R.id.tour3_1);
        card2 = findViewById(R.id.tour3_2);

        undo= findViewById(R.id.undo);

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

        undo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tour3.this, Pianifica.class);
                startActivity(intent);
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
