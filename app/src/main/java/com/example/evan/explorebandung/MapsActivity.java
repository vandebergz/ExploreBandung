package com.example.evan.explorebandung;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import static com.example.evan.explorebandung.R.id.map;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    boolean mapReady=false;
    int choice;

    LatLng bdo = new LatLng (-6.9144847999999 ,107.602303200000);
    CameraPosition BANDUNG = new CameraPosition(bdo, 13, 45, 0);

    LatLng bdr = new LatLng(-6.9040, 107.5802);
    CameraPosition BANDARA = new CameraPosition(bdr, 16, 45, 0);

    LatLng mol = new LatLng(-6.9251, 107.6365);
    CameraPosition MOL = new CameraPosition(mol, 16, 45, 0);

    LatLng cafe = new LatLng(-6.907145, 107.623315);
    CameraPosition CAFE = new CameraPosition(cafe, 17, 45, 0);

    LatLng wst = new LatLng(-7.1662, 107.4021);
    CameraPosition WISATA = new CameraPosition(wst, 16, 45, 0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(map);
        mapFragment.getMapAsync(this);

        //Getextra
        choice = getIntent().getExtras().getInt("NILAI", 0);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapReady = true;
        mMap = googleMap;

        if(choice==1) {
            mMap.moveCamera(CameraUpdateFactory.newCameraPosition(BANDUNG));

        }else if(choice==2){
            mMap.moveCamera(CameraUpdateFactory.newCameraPosition(BANDARA));
            mMap.addMarker(new MarkerOptions().position(bdr).title("Husein Sastranegara"));
        }else if(choice==3){
            mMap.moveCamera(CameraUpdateFactory.newCameraPosition(MOL));
            mMap.addMarker(new MarkerOptions().position(mol).title("Trans Studio"));
        }else if(choice==4){
            mMap.moveCamera(CameraUpdateFactory.newCameraPosition(CAFE));
            mMap.addMarker(new MarkerOptions().position(cafe).title("Bobbers"));
        }else{
            mMap.moveCamera(CameraUpdateFactory.newCameraPosition(WISATA));
            mMap.addMarker(new MarkerOptions().position(wst).title("Kawah Putih"));
        }
    }
}
