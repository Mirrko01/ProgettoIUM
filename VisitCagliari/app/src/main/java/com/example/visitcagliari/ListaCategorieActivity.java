package com.example.visitcagliari;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ListaCategorieActivity extends AppCompatActivity {

    ImageView churchBtn, museumBtn, parkBtn, monumentBtn, accountBtn, logout;
    Button pianificaBtn;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listacategorie_activity);

        churchBtn = findViewById(R.id.chieseImg);
        museumBtn = findViewById(R.id.museumImg);
        parkBtn = findViewById(R.id.parkImg);
        monumentBtn = findViewById(R.id.monumentImg);
        pianificaBtn = findViewById(R.id.pianifica);
        accountBtn=findViewById(R.id.account);
        logout=findViewById(R.id.logout);

        churchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaCategorieActivity.this, Chiese.class);
                startActivity(intent);
            }
        });

        museumBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaCategorieActivity.this, Musei.class);
                startActivity(intent);
            }
        });

        /*restaurantBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaCategorieActivity.this, Ristoranti.class);
                startActivity(intent);
            }
        });*/

        parkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaCategorieActivity.this, Parchi.class);
                startActivity(intent);
            }
        });

        monumentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaCategorieActivity.this, Monumenti.class);
                startActivity(intent);
            }
        });

        /*otherBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaCategorieActivity.this, Other.class);
                startActivity(intent);
            }
        });*/

        pianificaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaCategorieActivity.this, Pianifica.class);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConfirmationDialog();
            }
        });


        accountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaCategorieActivity.this, DatiPersonali.class);
                startActivity(intent);
            }
        });
    }

    private void showConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Sei sicuro di voler effettuare il logout?");
        builder.setPositiveButton("Sì, sono sicuro", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(ListaCategorieActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("No, voglio rimanere", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
