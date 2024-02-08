package com.example.visitcagliari;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Chiese extends AppCompatActivity {

    LinearLayout bonaria, saturnino, efisio,vergine;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chiese_activity);

        bonaria=findViewById(R.id.bonaria);
        saturnino=findViewById(R.id.saturnino);
        efisio=findViewById(R.id.efisio);
        vergine=findViewById(R.id.vergine);


        bonaria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Chiese.this, Bonaria.class);
                startActivity(intent);
            }
        });

        saturnino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Chiese.this, Saturnino.class);
                startActivity(intent);
            }
        });

        efisio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Chiese.this, Efisio.class);
                startActivity(intent);
            }
        });

        vergine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Chiese.this, Vergine.class);
                startActivity(intent);
            }
        });
    }
}
