package com.dani.ecoparque;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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


    private ProgressDialog pDialog;


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


        url = "http://freegeoip.net/json/" + urlEmpresa.getText().toString();

        pDialog = new ProgressDialog(DatosDominio.this);
        pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pDialog.setMessage("Procesando...");
        pDialog.setMax(1);


        new DownloadWebpageTask().execute(url);


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
            DialogFragment newFragment = new DesconectarFragment();
            newFragment.show(getFragmentManager(), "dialogo");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private class DownloadWebpageTask extends AsyncTask<String, Integer, String> {

        @Override
        protected void onPreExecute() {
            pDialog.setProgress(0);
            pDialog.show();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            int progreso = values[0].intValue();

            pDialog.setProgress(progreso);
        }

        @Override
        protected String doInBackground(String... urls) {

            // params comes from the execute() call: params[0] is the url.
            try {
                publishProgress(0);
                urlInfo = mapper.readValue(new URL(urls[0]), UrlInfo.class);
                publishProgress(1);
            } catch (
                    IOException e
                    ) {
                e.printStackTrace();
            }

            return "prueba";
        }


        @Override
        protected void onPostExecute(String result) {
            try {
                pDialog.dismiss();
                ip.setText(ip.getText().toString() + urlInfo.getIp());
                pais.setText(pais.getText().toString() + urlInfo.getCountry_name() + "(" + urlInfo.getCountry_code() + ")");
                localidad.setText(localidad.getText().toString() + urlInfo.getCity());
                coordenadas.setText(coordenadas.getText().toString() + urlInfo.getLatitude() + ", " + urlInfo.getLongitude());
            } catch (NullPointerException e) {
                Toast.makeText(getApplicationContext(), "No se ha podido acceder a la página web", 500).show();
            }
        }

    }
}


