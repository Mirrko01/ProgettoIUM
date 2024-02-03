package com.example.visitcagliari;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnSuccessListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class ItinerarioActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private FusedLocationProviderClient fusedLocationProviderClient;
    private Button btnOpenDirections;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itinerario);

        // Inizializza il FusedLocationProviderClient
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        // Inizializza la mappa asincronamente
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }

        // Inizializza il pulsante e aggiungi l'OnClickListener
        btnOpenDirections = findViewById(R.id.btnOpenDirections);
        btnOpenDirections.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDirections();
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Ottieni la posizione corrente e sposta la camera sulla posizione
        getLastKnownLocation();
    }

    private void getLastKnownLocation() {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        fusedLocationProviderClient.getLastLocation()
                .addOnSuccessListener(this, location -> {
                    if (location != null) {
                        // Ottieni la posizione corrente
                        double currentLat = location.getLatitude();
                        double currentLng = location.getLongitude();

                        // Sposta la camera sulla posizione corrente
                        LatLng currentLocation = new LatLng(currentLat, currentLng);
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 15f));
                    } else {
                        Toast.makeText(ItinerarioActivity.this, "Posizione non disponibile", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void openDirections() {
        // Sostituisci "LA_TUA_API_KEY" con la tua chiave API di Google Maps
        String apiKey = "AIzaSyD2XQ_-PJvrkNClNwzM5ikH463cxATdH8U";

        // Esempio di itinerario salvato (URL generato da Google Maps)
        String savedDirectionsUrl = "https://maps.app.goo.gl/XtcjwTgRXzb38eQMA";

        // Apri l'itinerario in una nuova finestra del browser
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(savedDirectionsUrl));
        startActivity(intent);
    }
}
