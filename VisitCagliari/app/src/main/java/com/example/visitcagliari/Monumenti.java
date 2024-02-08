package com.example.visitcagliari;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Monumenti extends AppCompatActivity {

    LinearLayout bastione, elefante, castello,cristinaa;

    ImageView undo;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.monumenti_activity);

        bastione=findViewById(R.id.bastione);
        elefante=findViewById(R.id.elefante);
        castello=findViewById(R.id.castello);
        cristinaa=findViewById(R.id.cristina);
        undo=findViewById(R.id.undo);

        undo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Monumenti.this, ListaCategorieActivity.class);
                startActivity(intent);
            }
        });

            bastione.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Monumenti.this, Bastione.class);
                startActivity(intent);
            }
        });

        elefante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Monumenti.this, Elefante.class);
                startActivity(intent);
            }
        });

        castello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Monumenti.this, Castello.class);
                startActivity(intent);
            }
        });

        cristinaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Monumenti.this, Cristina.class);
                startActivity(intent);
            }
        });
    }
}
