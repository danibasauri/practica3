package com.ecoparque.asyncTasks;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

import com.dani.ecoparque.R;
import com.ecoparque.objects.UrlInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

public class ParseWebTask extends AsyncTask<String, Integer, String> {
    Activity activity;
    private TextView ip, pais, localidad, coordenadas;
    private static final String DEBUG_TAG = "HttpExample";
    private ObjectMapper mapper = new ObjectMapper();
    private UrlInfo urlInfo;
    private ProgressDialog pDialog;

    public ParseWebTask(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected void onPreExecute() {
        pDialog = new ProgressDialog(activity);
        pDialog.setCancelable(false);
        pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pDialog.setMessage("Procesando...");
        pDialog.setMax(1);
        pDialog.setProgress(0);
        pDialog.show();
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
            ip = (TextView) activity.findViewById(R.id.ip);
            pais = (TextView) activity.findViewById(R.id.pais);
            localidad = (TextView) activity.findViewById(R.id.localidad);
            coordenadas = (TextView) activity.findViewById(R.id.coordenadas);

            ip.setText(ip.getText().toString() + urlInfo.getIp());
            pais.setText(pais.getText().toString() + urlInfo.getCountry_name() + "(" + urlInfo.getCountry_code() + ")");
            localidad.setText(localidad.getText().toString() + urlInfo.getCity());
            coordenadas.setText(coordenadas.getText().toString() + urlInfo.getLatitude() + ", " + urlInfo.getLongitude());
        } catch (NullPointerException e) {
            Toast.makeText(activity, "No se ha podido acceder a la página web", 500).show();
        }
    }

}
