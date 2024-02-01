package com.example.visitcagliari;
import com.example.visitcagliari.*;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;
import java.util.ArrayList;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity{

    TextView nome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        nome=findViewById(R.id.nome);
        nome.setText(MainActivity.loggedUser.nome);

    }
}
