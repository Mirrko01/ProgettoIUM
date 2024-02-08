package com.example.visitcagliari;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Monumenti extends AppCompatActivity {

    LinearLayout bastione, elefante, castello,cristina;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.monumenti_activity);

        bastione=findViewById(R.id.bastione);
        elefante=findViewById(R.id.elefante);
        castello=findViewById(R.id.castello);
        cristina=findViewById(R.id.cristina);


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

        cristina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Monumenti.this, Cristina.class);
                startActivity(intent);
            }
        });
    }
}
