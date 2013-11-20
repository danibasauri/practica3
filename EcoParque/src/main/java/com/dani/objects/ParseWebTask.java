package com.dani.objects;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

import com.dani.ecoparque.DatosDominio;
import com.dani.ecoparque.R;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

public class ParseWebTask extends AsyncTask<String, Integer, String> {
    Context c;
    private TextView ip, pais, localidad, coordenadas;
    private static final String DEBUG_TAG = "HttpExample";
    private ObjectMapper mapper = new ObjectMapper();
    private UrlInfo urlInfo;
    private ProgressDialog pDialog;

    public ParseWebTask(Context c) {
        this.c = c;
        pDialog = new ProgressDialog(c);
        pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pDialog.setMessage("Procesando...");
        pDialog.setMax(1);
        pDialog.setProgress(0);
        pDialog.show();

    }

    /*@Override
    protected void onPreExecute() {

    }*/

    @Override
    protected void onProgressUpdate(Integer... values) {
        int progreso = values[0].intValue();

        pDialog.setProgress(progreso);
    }

    @Override
    protected String doInBackground(String... urls) {
        try {
            publishProgress(0);
            urlInfo = mapper.readValue(new URL(urls[0]), UrlInfo.class);
            publishProgress(1);
        } catch (
                IOException e
                ) {
            e.printStackTrace();
        }
        return "";
    }


    @Override
    protected void onPostExecute(String result) {
        try {
            pDialog.dismiss();

            ip = (TextView) findViewById(R.id.ip);
            pais = (TextView) pais.findViewById(R.id.pais);
            localidad = (TextView) localidad.findViewById(R.id.localidad);
            coordenadas = (TextView) coordenadas.findViewById(R.id.coordenadas);

            ip.setText(ip.getText().toString() + urlInfo.getIp());
            pais.setText(pais.getText().toString() + urlInfo.getCountry_name() + "(" + urlInfo.getCountry_code() + ")");
            localidad.setText(localidad.getText().toString() + urlInfo.getCity());
            coordenadas.setText(coordenadas.getText().toString() + urlInfo.getLatitude() + ", " + urlInfo.getLongitude());
        } catch (NullPointerException e) {
            Toast.makeText(c, "No se ha podido acceder a la página web", 500).show();
        }
    }

}
