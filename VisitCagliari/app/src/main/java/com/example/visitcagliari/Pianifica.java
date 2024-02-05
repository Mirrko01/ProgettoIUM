package com.example.visitcagliari;

// MainActivity.java
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Pianifica extends AppCompatActivity {

    private EditText editTextDistance;
    private Spinner spinnerTransportation;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pianifica_activity);

        editTextDistance = findViewById(R.id.editTextDistance);
        spinnerTransportation = findViewById(R.id.spinnerTransportation);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        // Populating spinner with transportation options
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.transportation_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTransportation.setAdapter(adapter);

        // Setting click listener for the button
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateResult();
            }
        });
    }

    private void calculateResult() {
        // Get the entered distance
        String distanceStr = editTextDistance.getText().toString();

        if (!distanceStr.isEmpty()) {
            // Convert distance to double
            double distance = Double.parseDouble(distanceStr);

            // Get the selected transportation option
            String transportation = spinnerTransportation.getSelectedItem().toString();

            Intent intent;
            if ("A piedi".equals(transportation)) {
                intent = new Intent(Pianifica.this, Tour1.class);
            } else if ("In bus".equals(transportation)) {
                intent = new Intent(Pianifica.this, Tour2.class);
            } else if ("In bici".equals(transportation)) {
                intent = new Intent(Pianifica.this, Tour3.class);
            } else {
                intent = new Intent(Pianifica.this, Tour4.class);
            }

            // Pass data to the next activity if needed
            intent.putExtra("distance", distance);

            // Start the new activity
            startActivity(intent);
        } else {
            // Display an error message if distance is not entered
            Toast.makeText(Pianifica.this, "Inserisci la distanza", Toast.LENGTH_SHORT).show();
        }
    }
}
