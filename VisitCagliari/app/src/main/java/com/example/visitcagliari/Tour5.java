package com.example.visitcagliari;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

public class Tour5 extends AppCompatActivity {

    ImageView undo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tour5_activity);

        undo= findViewById(R.id.undo);

        undo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tour5.this, Pianifica.class);
                startActivity(intent);
            }
        });
    }

}
