package com.ecoparque.activites;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ecoparque.R;
import com.ecoparque.objects.NetInfo;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapaDominio extends Activity {
    private String browserUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_mapa_dominio);
        final Intent intent = getIntent();
        final NetInfo netInfo = new NetInfo(MapaDominio.this);


        final GoogleMap mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
                .getMap();

        mMap.setMyLocationEnabled(true);
        mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker arg0) {
                return null;
            }

            @Override
            public View getInfoContents(Marker arg0) {

                View v = getLayoutInflater().inflate(R.layout.map_pin_info, null);

                TextView ciudad = (TextView) v.findViewById(R.id.firstLine);
                TextView url = (TextView) v.findViewById(R.id.secondLine);

                ciudad.setText(intent.getStringExtra("ciudad"));
                url.setText(intent.getStringExtra("url"));

                return v;
            }
        });

        mMap.clear();

        MarkerOptions markerOptions = new MarkerOptions();

        LatLng latLong = new LatLng(Double.parseDouble(intent.getStringExtra("lat")),
                Double.parseDouble(intent.getStringExtra("lon")));
        markerOptions.position(latLong);
        markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.server));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLong, 13.0f));
        Marker marker = mMap.addMarker(markerOptions);
        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {

            @Override
            public void onInfoWindowClick(Marker marker) {

                if (netInfo.isConnected()) {
                    if (!intent.getStringExtra("url").startsWith("https://") && !intent.getStringExtra("url").startsWith("http://"))
                        browserUrl = "http://" + intent.getStringExtra("url");
                    Uri uri = Uri.parse(browserUrl);
                    startActivity(new Intent(Intent.ACTION_VIEW, uri));
                } else {
                    Toast.makeText(getApplicationContext(), "Comprueba tu conexión a internet", 1000).show();
                }
            }
        });
        marker.showInfoWindow();
    }
}
