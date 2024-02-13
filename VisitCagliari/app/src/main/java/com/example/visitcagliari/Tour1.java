package com.example.visitcagliari;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

public class Tour1 extends AppCompatActivity {
    MaterialCardView card1;
    MaterialCardView card2;

    ImageView undo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tour1_activity);

        // Trova le card
         card1 = findViewById(R.id.apriItin1);
         card2 = findViewById(R.id.apriItin2);

         undo= findViewById(R.id.undo);

        // Aggiungi il click listener alle card
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showConfirmationDialog("https://maps.app.goo.gl/LC8aPQ4BUNcHqi6eA");
            }
        });

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showConfirmationDialog("https://maps.app.goo.gl/XXwftAFdwoMHjLSY6");
            }
        });

        undo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tour1.this, Pianifica.class);
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

    private void showConfirmationDialog(String url) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Il tour sta per iniziare, verrai reindirizzato su Google Maps!");
        builder.setPositiveButton("Va bene", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                openDirections(url);

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
