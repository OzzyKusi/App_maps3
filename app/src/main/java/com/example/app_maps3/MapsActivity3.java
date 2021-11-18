package com.example.app_maps3;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.example.app_maps3.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity3 extends FragmentActivity implements OnMapReadyCallback {

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
                .findFragmentById(R.id.map3);
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
        UiSettings uiset=mMap.getUiSettings();
        uiset.setZoomControlsEnabled(true);

        //Restaurantes
        BitmapDrawable bt013 = (BitmapDrawable) getResources().getDrawable(R.drawable.restaurant);
        Bitmap bit013 = bt013.getBitmap();
        Bitmap bit013p = Bitmap.createScaledBitmap(bit013, 70, 70, false);
        BitmapDrawable bt014 = (BitmapDrawable) getResources().getDrawable(R.drawable.restaurant);
        Bitmap bit014 = bt014.getBitmap();
        Bitmap bit014p = Bitmap.createScaledBitmap(bit014, 70, 70, false);
        BitmapDrawable bt015 = (BitmapDrawable) getResources().getDrawable(R.drawable.restaurant);
        Bitmap bit015 = bt015.getBitmap();
        Bitmap bit015p = Bitmap.createScaledBitmap(bit015, 70, 70, false);
        BitmapDrawable bt016 = (BitmapDrawable) getResources().getDrawable(R.drawable.restaurant);
        Bitmap bit016 = bt016.getBitmap();
        Bitmap bit016p = Bitmap.createScaledBitmap(bit016, 70, 70, false);


        LatLng rest1=new LatLng(-13.519250, -71.974898);
        mMap.addMarker(new MarkerOptions().position(rest1).icon(BitmapDescriptorFactory.fromBitmap(bit013p)).title("Inti Raymi"));
        LatLng rest2=new LatLng(-13.516794, -71.980688);
        mMap.addMarker(new MarkerOptions().position(rest2).icon(BitmapDescriptorFactory.fromBitmap(bit014p)).title("Yaku Restaurant"));
        LatLng rest3=new LatLng(-13.515210386132255, -71.97841272998771);
        mMap.addMarker(new MarkerOptions().position(rest3).icon(BitmapDescriptorFactory.fromBitmap(bit015p)).title("Organika Restaurant"));
        LatLng rest4=new LatLng(-13.514660695434545, -71.97938265902249);
        mMap.addMarker(new MarkerOptions().position(rest4).icon(BitmapDescriptorFactory.fromBitmap(bit016p)).title("Wachafos Restaurant"));


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

                Toast.makeText(MapsActivity3.this, "Lat: " + pos.latitude + " , " + "Long: " + pos.longitude, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}