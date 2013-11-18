package com.dani.ecoparque;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dani.utils.Validador;

public class DatosEmpresa extends Activity {
    private EditText nif, tlf, mail, url, nombre;
    private Button btnTlf, btnMail, btnUrl, btnSiguiente, btnInfoDom;
    private Validador validador = new Validador();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_datos_empresa);

        Intent intent = getIntent();
        String message = intent.getStringExtra(SeleccionUsuario.EXTRA_MESSAGE);

        nif = (EditText) findViewById(R.id.empr_cif);
        nif.setText(message);

        nombre = (EditText) findViewById(R.id.empr_nombre);

        tlf = (EditText) findViewById(R.id.empr_tlf);

        mail = (EditText) findViewById(R.id.empr_mail);

        url = (EditText) findViewById(R.id.empr_url);


        btnTlf = (Button) findViewById(R.id.btn_llamar);
        btnMail = (Button) findViewById(R.id.btn_enviar);
        btnUrl = (Button) findViewById(R.id.btn_abrir);

        btnSiguiente = (Button) findViewById(R.id.btn_siguiente);
        btnInfoDom = (Button) findViewById(R.id.btn_info_dominio);

        tlf.addTextChangedListener(mTextEditorWatcher);
        mail.addTextChangedListener(mTextEditorWatcher);
        url.addTextChangedListener(mTextEditorWatcher);
        nombre.addTextChangedListener(mTextEditorWatcher);


        btnTlf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String uri = "tel:" + tlf.getText().toString().trim();
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse(uri));
                startActivity(intent);
            }
        });


        btnMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_SEND);

                email.setType("message/rfc822");
                //email.putExtra(Intent.EXTRA_EMAIL, );
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{mail.getText().toString()});
                startActivity(email);
            }
        });

        btnUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!url.getText().toString().startsWith("https://") && !url.getText().toString().startsWith("http://"))
                    url.setText("http://" + url.getText().toString());
                Uri uri = Uri.parse(url.getText().toString());
                startActivity(new Intent(Intent.ACTION_VIEW, uri));
            }
        });

        btnInfoDom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringUrl = url.getText().toString();
                ConnectivityManager connMgr = (ConnectivityManager)
                        getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isConnected()) {
                    Intent intent = new Intent(DatosEmpresa.this, DatosDominio.class);
                    url.setText("http://freegeoip.net/json/" + url.getText().toString());
                    intent.putExtra("urlEmpresa", url.getText().toString());
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Error al intentar conectarse a internet", 1000).show();
                }
            }
        }


        );

        btnSiguiente.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DatosEmpresa.this, Depositante.class);

                intent.putExtra(SeleccionUsuario.EXTRA_MESSAGE, nif.getText().toString());
                intent.putExtra("from", "empresa");
                startActivity(intent);
            }
        }

        );
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.datos_empresa, menu);
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

// EditTextWacther  Implementation

    private final TextWatcher mTextEditorWatcher = new TextWatcher() {


        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        public void afterTextChanged(Editable s) {


            btnTlf.setEnabled(!tlf.getText().toString().isEmpty());
            btnMail.setEnabled(validador.validateEmail(mail.getText().toString()));
            btnUrl.setEnabled(!url.getText().toString().trim().isEmpty());
            btnInfoDom.setEnabled(!url.getText().toString().trim().isEmpty());


            boolean nombreFilled = !nombre.getText().toString().isEmpty();
            if (btnTlf.isEnabled() && btnMail.isEnabled() && btnUrl.isEnabled() && nombreFilled)
                btnSiguiente.setEnabled(true);
            else
                btnSiguiente.setEnabled(false);


        }


    };

}
