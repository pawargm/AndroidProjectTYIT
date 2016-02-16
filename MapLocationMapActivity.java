package com.example.gopal.maplocation;

import android.content.DialogInterface;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, View.OnClickListener,LocationListener {

    private GoogleMap mMap;
    public EditText tv;
    public Button btn;
    private Location lo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        //set();

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

/*    public void onSearch(View v)
    {

        String str=tv.getText().toString();
        List<Address> ll=null;

        if(str!=null || str.equals(""))
        {
            Geocoder ge=new Geocoder(this);
            try
            {
                ll=ge.getFromLocationName(str,1);
            }catch(Exception e)
            {
                e.printStackTrace();
            }
            Address ad=ll.get(0);
            LatLng latlng=new LatLng(ad.getLatitude(),ad.getLongitude());
            mMap.addMarker(new MarkerOptions().position(latlng).title("Marker in your Choice"));
            mMap.animateCamera(CameraUpdateFactory.newLatLng(latlng));
        }


    }*/
    //public void setMap()
    //{
      //  btn.setOnClickListener(this);

    //}




    //@Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        tv=(EditText)findViewById(R.id.stext);
        btn=(Button)findViewById(R.id.sbtn);
        btn.setOnClickListener(this);

    }


    @Override
    public void onClick(View v)
    {
        String str=tv.getText().toString();
        List<Address> ll=null;

        if(str!=null || str.equals(""))
        {
            Geocoder ge=new Geocoder(this);
            try
            {
                ll=ge.getFromLocationName(str,1);
            }catch(Exception e)
            {
                e.printStackTrace();
            }
            Address ad=ll.get(0);
            LatLng latlng=new LatLng(ad.getLatitude(),ad.getLongitude());
            //Toast.makeText(getApplicationContext(),ad.getLatitude()+ad.getLongitude()+"X,Y",Toast.LENGTH_SHORT);
            mMap.addMarker(new MarkerOptions().position(latlng).title("Marker in your Choice"));
            mMap.animateCamera(CameraUpdateFactory.newLatLng(latlng));
        }
        /*double lat=lo.getLatitude();
        double lan=lo.getLongitude();
        LatLng latlng=new LatLng(lat,lan);
        mMap.addMarker(new MarkerOptions().position(latlng).title("Marker in your Choice"));
        mMap.animateCamera(CameraUpdateFactory.newLatLng(latlng));
        */

    }


    @Override
    public void onLocationChanged(Location location)
    {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras)
    {

    }

    @Override
    public void onProviderEnabled(String provider)
    {

    }

    @Override
    public void onProviderDisabled(String provider)
    {

    }
}
