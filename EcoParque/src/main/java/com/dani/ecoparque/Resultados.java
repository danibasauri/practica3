package com.dani.ecoparque;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Resultados extends Activity {
    private LinearLayout coste;
    private Button enviarMail, registroNuevo;
    private TextView ident, matInf, aceites, neveras, cantResiduos, txtCalculo, txtPrecio, txtIVA, txtTotal, iva, total;
    private String contenidoMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_resultados);
        Intent intent = getIntent();
        String activity = intent.getStringExtra("from");
        String matInfIntent = intent.getStringExtra("matInf");
        String neverasIntent = intent.getStringExtra("neveras");
        String aceitesIntent = intent.getStringExtra("aceites");
        Integer cont = 0;
        String message = intent.getStringExtra(SeleccionUsuario.EXTRA_MESSAGE);
        ident = (TextView) findViewById(R.id.str_id_depositante);
        ident.setText(message);
        iva = (TextView) findViewById(R.id.IVA);
        total = (TextView) findViewById(R.id.total);
        matInf = (TextView) findViewById(R.id.mat_informatico);
        neveras = (TextView) findViewById(R.id.neveras);
        aceites = (TextView) findViewById(R.id.aceites);
        cantResiduos = (TextView) findViewById(R.id.cant_residuos);

        contenidoMensaje = "Depositante:" + "\t" + ident.getText().toString() + "\n";
        contenidoMensaje += "Residuos depositados: \n";

        if (matInfIntent.equalsIgnoreCase("true")) {
            matInf = (TextView) findViewById(R.id.mat_informatico);
            matInf.setVisibility(View.VISIBLE);
            contenidoMensaje += "\t" + matInf.getText().toString() + "\n";
            cont++;
        }

        if (neverasIntent.equalsIgnoreCase("true")) {
            neveras = (TextView) findViewById(R.id.neveras);
            neveras.setVisibility(View.VISIBLE);
            contenidoMensaje += "\t" + neveras.getText().toString() + "\n";
            cont++;
        }

        if (aceitesIntent.equalsIgnoreCase("true")) {
            aceites = (TextView) findViewById(R.id.aceites);
            aceites.setVisibility(View.VISIBLE);
            contenidoMensaje += "\t" + aceites.getText().toString() + "\n";
            cont++;
        }

        if (cont == 1) {
            cantResiduos.setText("1 residuo depositado:");
        } else {
            cantResiduos.setText(cont + " residuos depositados:");
        }


        if (activity.equalsIgnoreCase("empresa")) {
            coste = (LinearLayout) findViewById(R.id.layout_coste);
            coste.setVisibility(View.VISIBLE);

            String peso = intent.getStringExtra("peso");
            txtCalculo = (TextView) findViewById(R.id.txt_calculo);
            txtCalculo.setText(peso + "Kg * 2,4€/Kg");

            txtPrecio = (TextView) findViewById(R.id.precio_calculo);
            BigDecimal resultadoInt = BigDecimal.valueOf(Integer.parseInt(peso) * 2.4);
            txtPrecio.setText("€ " + String.valueOf(resultadoInt.setScale(2, RoundingMode.CEILING)));

            txtIVA = (TextView) findViewById(R.id.precio_iva);
            BigDecimal resultadoIVA = BigDecimal.valueOf(resultadoInt.intValue() * 0.21);
            txtIVA.setText("€ " + String.valueOf(resultadoIVA.setScale(2, RoundingMode.CEILING)));

            txtTotal = (TextView) findViewById(R.id.precio_total);
            BigDecimal resultadoTotal = resultadoInt.add(resultadoIVA);
            txtTotal.setText("€ " + String.valueOf(resultadoTotal.setScale(2, RoundingMode.CEILING)));

            contenidoMensaje += "\n";
            contenidoMensaje += txtCalculo.getText().toString() + "\t" + txtPrecio.getText().toString() + "\n";
            contenidoMensaje += iva.getText().toString() + "\t" + txtIVA.getText().toString() + "\n";
            contenidoMensaje += total.getText().toString() + "\t" + txtTotal.getText().toString() + "\n";

        }

        enviarMail = (Button) findViewById(R.id.enviar_mail);
        enviarMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_SUBJECT, "Resultados depósito");
                email.putExtra(Intent.EXTRA_TEXT, contenidoMensaje);
                email.setType("message/rfc822");
                startActivity(email);
            }
        });

        registroNuevo = (Button) findViewById(R.id.registrar_deposito);
        registroNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Resultados.this, SeleccionUsuario.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Depósito registrado con éxito!", 1000).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.resultados, menu);
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


}
