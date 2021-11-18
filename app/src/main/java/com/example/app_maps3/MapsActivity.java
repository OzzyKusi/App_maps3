package com.example.app_maps3;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.app_maps3.databinding.ActivityMapsBinding;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private ArrayList markerPoints = new ArrayList();
    private Marker mark;
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
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        UiSettings uiset = mMap.getUiSettings();
        uiset.setZoomControlsEnabled(true);
        // Add a marker in Sydney and move the camera
        BitmapDrawable bt01 = (BitmapDrawable) getResources().getDrawable(R.drawable.pizeria);
        Bitmap bit01 = bt01.getBitmap();
        Bitmap bit01p = Bitmap.createScaledBitmap(bit01, 70, 70, false);
        BitmapDrawable bt02 = (BitmapDrawable) getResources().getDrawable(R.drawable.pizeria);
        Bitmap bit02 = bt02.getBitmap();
        Bitmap bit02p = Bitmap.createScaledBitmap(bit02, 70, 70, false);
        BitmapDrawable bt03 = (BitmapDrawable) getResources().getDrawable(R.drawable.pizeria);
        Bitmap bit03 = bt03.getBitmap();
        Bitmap bit03p = Bitmap.createScaledBitmap(bit03, 70, 70, false);
        BitmapDrawable bt04 = (BitmapDrawable) getResources().getDrawable(R.drawable.pizeria);
        Bitmap bit04 = bt04.getBitmap();
        Bitmap bit04p = Bitmap.createScaledBitmap(bit04, 70, 70, false);



        LatLng restPiz1=new LatLng(-13.51802928698439, -71.9755420471669);
        mMap.addMarker(new MarkerOptions().position(restPiz1).icon(BitmapDescriptorFactory.fromBitmap(bit01p)).title("Nonna Trattoria"));
        LatLng restPiz2=new LatLng(-13.518187163865656, -71.97562953758793);
        mMap.addMarker(new MarkerOptions().position(restPiz2).icon(BitmapDescriptorFactory.fromBitmap(bit02p)).title("La pizza Carlo"));
        LatLng restPiz3=new LatLng(-13.515924742142513, -71.97556645943392);
        mMap.addMarker(new MarkerOptions().position(restPiz3).icon(BitmapDescriptorFactory.fromBitmap(bit03p)).title("El Tabuco"));

        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {
                //Para limpiar los marcadores
                /*if(markerPoints.size()>1){
                    markerPoints.clear();
                    mMap.clear();
                }*/

                markerPoints.add(latLng);
                MarkerOptions opt = new MarkerOptions();
                opt.position(latLng);
                if (markerPoints.size() == 1) {
                    opt.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
                }
                mMap.addMarker(opt);
                if (markerPoints.size() >= 2) {
                    LatLng origen = (LatLng) markerPoints.get(0);
                    LatLng destino = (LatLng) mark.getPosition();
                    //String url = getDirectionsUrl(origen,destino);
                    //DownloadTask dw = new DownloadTask();
                    //dw.execute(url);
                }
            }
        });

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                LatLng pos = marker.getPosition();

                Toast.makeText(MapsActivity.this, "Lat: " + pos.latitude + " , " + "Long: " + pos.longitude, Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }

}