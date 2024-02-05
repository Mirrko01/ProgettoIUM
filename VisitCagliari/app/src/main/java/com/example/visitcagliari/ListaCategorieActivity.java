package com.example.visitcagliari;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ListaCategorieActivity extends AppCompatActivity {

    ImageView churchBtn, museumBtn, restaurantBtn, parkBtn, monumentBtn, otherBtn, accountBtn;

    Button pianificaBtn;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listacategorie_activity);

        churchBtn = findViewById(R.id.chieseImg);
        museumBtn = findViewById(R.id.museumImg);
        restaurantBtn = findViewById(R.id.restaurantImg);
        parkBtn = findViewById(R.id.parkImg);
        monumentBtn = findViewById(R.id.monumentImg);
        //otherBtn = findViewById(R.id.otherImg);
        pianificaBtn = findViewById(R.id.pianifica);
        accountBtn=findViewById(R.id.account);

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

        restaurantBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaCategorieActivity.this, Ristoranti.class);
                startActivity(intent);
            }
        });

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


        accountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaCategorieActivity.this, DatiPersonali.class);
                startActivity(intent);
            }
        });




    }
}
