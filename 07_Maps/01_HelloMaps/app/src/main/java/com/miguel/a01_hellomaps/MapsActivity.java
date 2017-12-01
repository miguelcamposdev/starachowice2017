package com.miguel.a01_hellomaps;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMarkerDragListener {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
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
        LatLng seville = new LatLng(37.380433,-6.006989);
        mMap.addMarker(
                new MarkerOptions()
                        .position(seville)
                        .title("Android Course in Seville")
                        .snippet("We are here: 37.380433,-6.006989")
        );

        LatLng starachowice = new LatLng(51.054469,21.063302);
        mMap.addMarker(
                new MarkerOptions()
                        .position(starachowice)
                        .title("Starachowice Developers Office")
                        .snippet("We are here: 51.054469,21.063302")
        );


        CircleOptions circleOptions = new CircleOptions()
                .center(starachowice)
                .fillColor(ContextCompat.getColor(this,R.color.colorWhiteTransparent))
                .radius(1000);
        Circle circle = mMap.addCircle(circleOptions);


        mMap.moveCamera(CameraUpdateFactory.newLatLng(starachowice));

        mMap.setOnMapClickListener(this);
        mMap.setOnMarkerDragListener(this);
    }

    @Override
    public void onMapClick(LatLng latLng) {
        mMap.addMarker(new MarkerOptions()
        .position(latLng)
        .title("You clicked here!")
        .snippet("We are here: "+latLng.latitude+","+latLng.longitude)
        .draggable(true)
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_marker))
        );
    }

    @Override
    public void onMarkerDragStart(Marker marker) {
        // Hide the marker dialog == InfoWindow
        marker.hideInfoWindow();
    }

    @Override
    public void onMarkerDrag(Marker marker) {
        LatLng currentPosition = marker.getPosition();
        Log.i("MARKER","Position: "
                +currentPosition.latitude
                +","+currentPosition.longitude);
    }

    @Override
    public void onMarkerDragEnd(Marker marker) {
        LatLng position = marker.getPosition();
        marker.setTitle("New position!");
        marker.setSnippet("Location: "+position.latitude+","+position.longitude);
        marker.showInfoWindow();
    }
}
