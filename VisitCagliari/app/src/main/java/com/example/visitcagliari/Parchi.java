package com.example.visitcagliari;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Parchi extends AppCompatActivity {

    LinearLayout monteclaro, urpinu, terramaini,giardini;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parchi_activity);

        monteclaro=findViewById(R.id.monteclaro);
        urpinu=findViewById(R.id.urpinu);
        terramaini=findViewById(R.id.terramaini);
        giardini=findViewById(R.id.giardini);


        monteclaro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Parchi.this, Monumenti.class);
                startActivity(intent);
            }
        });

        urpinu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Parchi.this, Monumenti.class);
                startActivity(intent);
            }
        });

        terramaini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Parchi.this, Monumenti.class);
                startActivity(intent);
            }
        });

        giardini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Parchi.this, Monumenti.class);
                startActivity(intent);
            }
        });
    }
}
