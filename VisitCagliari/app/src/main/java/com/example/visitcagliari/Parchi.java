package com.example.visitcagliari;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Parchi extends AppCompatActivity {

    LinearLayout monteclaro, urpinu, terramaini,giardini;
    ImageView undo;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parchi_activity);

        monteclaro=findViewById(R.id.monteclaro);
        urpinu=findViewById(R.id.urpinu);
        terramaini=findViewById(R.id.terramaini);
        giardini=findViewById(R.id.giardini);
        undo=findViewById(R.id.undo);

        undo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Parchi.this, ListaCategorieActivity.class);
                startActivity(intent);
            }
        });
        monteclaro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Parchi.this, Monteclaro.class);
                startActivity(intent);
            }
        });

        urpinu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Parchi.this, Urpinu.class);
                startActivity(intent);
            }
        });

        terramaini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Parchi.this, Terramaini.class);
                startActivity(intent);
            }
        });

        giardini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Parchi.this, Giardini.class);
                startActivity(intent);
            }
        });
    }
}
