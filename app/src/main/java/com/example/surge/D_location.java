
package com.example.surge;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.core.app.ActivityCompat;
        import androidx.core.content.ContextCompat;
        import androidx.fragment.app.FragmentActivity;

        import android.Manifest;
        import android.content.pm.PackageManager;
        import android.location.Address;
        import android.location.Geocoder;
        import android.location.Location;
        import android.os.Build;
        import android.os.Bundle;
        import android.text.TextUtils;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.ImageButton;
        import android.widget.Toast;

        import com.google.android.gms.common.ConnectionResult;
        import com.google.android.gms.common.internal.GoogleApiAvailabilityCache;
        import com.google.android.gms.location.LocationListener;

        import com.google.android.gms.common.api.GoogleApi;
        import com.google.android.gms.common.api.GoogleApiClient;
        import com.google.android.gms.location.LocationRequest;
        import com.google.android.gms.location.LocationServices;
        import com.google.android.gms.maps.CameraUpdateFactory;
        import com.google.android.gms.maps.GoogleMap;
        import com.google.android.gms.maps.OnMapReadyCallback;
        import com.google.android.gms.maps.SupportMapFragment;
        import com.google.android.gms.maps.model.BitmapDescriptorFactory;
        import com.google.android.gms.maps.model.LatLng;
        import com.google.android.gms.maps.model.Marker;
        import com.google.android.gms.maps.model.MarkerOptions;
        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.database.ValueEventListener;

        import java.io.IOException;
        import java.text.BreakIterator;
        import java.util.List;

public class D_location extends FragmentActivity implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {

    private GoogleMap mMap;
    private GoogleApiClient googleApiClient;
    private LocationRequest locationRequest;
    private Location lastLocation;
    private Marker currentUserLocationMarker;
    private static final int Request_User_Location_Code=99;

    ImageButton search_loc;
    EditText search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_location);

        //   search = findViewById(R.id.search);
        search_loc = findViewById(R.id.search_loc);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkUserLocationPermission();
        }


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
        {
            // buildGoogleApiClient();
        }
        mMap.setMyLocationEnabled(true);

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Location");

        ValueEventListener listener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Double latitude = dataSnapshot.child("latitude").getValue(Double.class);
                Double longitude =dataSnapshot.child("longitude").getValue(Double.class);

                Double latitude1 = dataSnapshot.child("latitude1").getValue(Double.class);
                Double longitude1 =dataSnapshot.child("longitude1").getValue(Double.class);

                LatLng location = new LatLng(latitude,longitude);
                LatLng location1 = new LatLng(latitude1,longitude1);

                mMap.addMarker(new MarkerOptions().position(location).title("Donation place 1"));
                mMap.addMarker(new MarkerOptions().position(location1).title("Donation place 2"));

                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location,12));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location1,12));



                MarkerOptions place1 = new MarkerOptions().position(new LatLng(latitude,longitude));

                //     String url = getUrl(place1.getPosition(),"driving");

            }



            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

//    private String getUrl(LatLng origin, String directionMode) {
//
//        // Origin of route
//        String str_origin = "origin=" + origin.latitude + "," + origin.longitude;
//        // Destination of route
//        String str_dest = "destination=" + dest.latitude + "," + dest.longitude;
//        // Mode
//        String mode = "mode=" + directionMode;
//        // Building the parameters to the web service
//        String parameters = str_origin + "&" + str_dest + "&" + mode;
//        // Output format
//        String output = "json";
//        // Building the url to the web service
//        String url = "https://maps.googleapis.com/maps/api/directions/" + output + "?" + parameters + "&key=" + getString(R.string.google_maps_key);
//        return url;
//    }



    protected synchronized void buildGoogleApiClient()
    {
        googleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

        googleApiClient.connect();

    }









    @Override
    public void onLocationChanged(Location location) {

        // latitude =location.getLatitude();
        // longtitude=location.getLongitude();
        lastLocation = location;

        if(currentUserLocationMarker != null)
        {
            currentUserLocationMarker.remove();
        }

        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("User Current Location");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));

        currentUserLocationMarker = mMap.addMarker(markerOptions);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomBy(14));

        if(googleApiClient != null)
        {
            LocationServices.FusedLocationApi.removeLocationUpdates(googleApiClient,this);
        }

    }


    public boolean checkUserLocationPermission()
    {

        if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION))
            {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, Request_User_Location_Code);
            }
            else
            {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, Request_User_Location_Code);

            }
            return false;
        }
        else
        {
            return true;
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode)
        {
            case Request_User_Location_Code:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
                    {
                        if (googleApiClient == null)
                        {
                            buildGoogleApiClient();
                        }
                        mMap.setMyLocationEnabled(true);
                    }
                }
                else {
                    Toast.makeText(this,"Permission Denied",Toast.LENGTH_SHORT).show();
                }
        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

        locationRequest = new LocationRequest();
        locationRequest.setInterval(1100);
        locationRequest.setFastestInterval(1100);
        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);

        if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
        {
            LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient,locationRequest,this);
        }

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}