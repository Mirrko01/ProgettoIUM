package com.example.visitcagliari;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Musei extends AppCompatActivity {

    LinearLayout archeologico, pinacoteca, cittadella,galleria;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.musei_activity);

        archeologico=findViewById(R.id.archeologico);
        pinacoteca=findViewById(R.id.pinacoteca);
        cittadella=findViewById(R.id.cittadella);
        galleria=findViewById(R.id.galleria);


        archeologico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Musei.this, Monumenti.class);
                startActivity(intent);
            }
        });

        pinacoteca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Musei.this, Monumenti.class);
                startActivity(intent);
            }
        });

        cittadella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Musei.this, Monumenti.class);
                startActivity(intent);
            }
        });

        galleria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Musei.this, Monumenti.class);
                startActivity(intent);
            }
        });
    }
}
