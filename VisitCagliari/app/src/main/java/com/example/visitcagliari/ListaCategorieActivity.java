package com.example.visitcagliari;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ListaCategorieActivity extends AppCompatActivity {

    private ImageView churcButton;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.listacategorie_activity);

        churcButton=findViewById(R.id.chieseImg);

        churcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaCategorieActivity.this, Chiese.class);
                startActivity(intent);
            }
        });
    }
}
