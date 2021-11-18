package com.example.app_maps3;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.app_maps3.databinding.ActivityMapsBinding;

import java.util.ArrayList;

public class MapsActivity2 extends FragmentActivity implements OnMapReadyCallback {

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
                .findFragmentById(R.id.map2);
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
        //Pollerias
        BitmapDrawable bt05 = (BitmapDrawable) getResources().getDrawable(R.drawable.polleria);
        Bitmap bit05 = bt05.getBitmap();
        Bitmap bit05p = Bitmap.createScaledBitmap(bit05, 70, 70, false);
        BitmapDrawable bt06 = (BitmapDrawable) getResources().getDrawable(R.drawable.polleria);
        Bitmap bit06 = bt06.getBitmap();
        Bitmap bit06p = Bitmap.createScaledBitmap(bit06, 70, 70, false);
        BitmapDrawable bt07 = (BitmapDrawable) getResources().getDrawable(R.drawable.polleria);
        Bitmap bit07 = bt07.getBitmap();
        Bitmap bit07p = Bitmap.createScaledBitmap(bit07, 70, 70, false);
        BitmapDrawable bt08 = (BitmapDrawable) getResources().getDrawable(R.drawable.polleria);
        Bitmap bit08 = bt08.getBitmap();
        Bitmap bit08p = Bitmap.createScaledBitmap(bit08, 70, 70, false);


        LatLng restPo1=new LatLng(-13.519134326158463, -71.97880282961988);
        mMap.addMarker(new MarkerOptions().position(restPo1).icon(BitmapDescriptorFactory.fromBitmap(bit05p)).title("Los Toldos Chicken"));
        LatLng restPo2=new LatLng(-13.518714527396451, -71.97841207132737);
        mMap.addMarker(new MarkerOptions().position(restPo2).icon(BitmapDescriptorFactory.fromBitmap(bit06p)).title("Etapoy"));
        LatLng restPo3=new LatLng(-13.518784864330009, -71.98087470201519);
        mMap.addMarker(new MarkerOptions().position(restPo3).icon(BitmapDescriptorFactory.fromBitmap(bit07p)).title("Grimaldos"));


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

                Toast.makeText(MapsActivity2.this, "Lat: " + pos.latitude + " , " + "Long: " + pos.longitude, Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }
}