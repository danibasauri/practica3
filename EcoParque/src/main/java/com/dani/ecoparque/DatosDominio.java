package com.dani.ecoparque;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.dani.objects.UrlInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

public class DatosDominio extends Activity {
    private EditText urlEmpresa;
    private TextView ip, pais, localidad, coordenadas;
    private static final String DEBUG_TAG = "HttpExample";
    private ObjectMapper mapper = new ObjectMapper();
    private UrlInfo urlInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_datos_dominio);

        Intent intent = getIntent();
        String url = intent.getStringExtra("urlEmpresa");

        urlEmpresa = (EditText) findViewById(R.id.url_empresa);
        urlEmpresa.setText(url);

        ip = (TextView) findViewById(R.id.ip);
        pais = (TextView) findViewById(R.id.pais);
        localidad = (TextView) findViewById(R.id.localidad);
        coordenadas = (TextView) findViewById(R.id.coordenadas);


        new DownloadWebpageTask().execute(urlEmpresa.getText().toString());

        if (savedInstanceState == null) {

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.datos_dominio, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private class DownloadWebpageTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            // params comes from the execute() call: params[0] is the url.
            try {

                urlInfo = mapper.readValue(new URL(urlEmpresa.getText().toString()), UrlInfo.class);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return "preuba";
        }


        @Override
        protected void onPostExecute(String result) {
            ip.setText(urlInfo.getIp());
            pais.setText(urlInfo.getCountry_name());
            localidad.setText(urlInfo.getCity());
            coordenadas.setText(urlInfo.getLatitude());
        }

    }
}


