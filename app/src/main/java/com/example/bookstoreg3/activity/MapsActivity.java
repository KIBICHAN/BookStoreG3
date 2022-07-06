package com.example.bookstoreg3.activity;

import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;

import com.example.bookstoreg3.R;
import com.example.bookstoreg3.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    /**
     * dummy store
     * 10.841880, 106.810942
     */
    private final LatLng LC1 = new LatLng(10.841880, 106.810942);
    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private Marker markerLC1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        //fpt pin
        //10.841171466891268, 106.81001605173263
        LatLng fpt = new LatLng(10.841171466891268, 106.81001605173263);
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.addMarker(new MarkerOptions().position(fpt).title("FPT UNIVERSITY").snippet("Vị trí của bạn."));
        Float zoomLevel = 15.5f;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(fpt, zoomLevel));
        googleMap.setTrafficEnabled(true);

        markerLC1 = mMap.addMarker(new MarkerOptions().position(LC1).title("Open Books").snippet("Long Thạnh Mỹ, District 9, Ho Chi Minh City, Vietnam"));
        markerLC1.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.logo_small));
        markerLC1.setTag(0);
    }
}