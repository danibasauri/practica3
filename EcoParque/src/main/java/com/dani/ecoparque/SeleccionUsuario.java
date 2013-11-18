package com.dani.ecoparque;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.dani.utils.Validador;

public class SeleccionUsuario extends Activity {
    //protected EditText editTextEmail = (EditText) findViewById(R.id.email);
    private EditText editTextIdent;
    private Button botonIniciar;
    public final static String EXTRA_MESSAGE = "com.dani.ecoparque.SeleccionUsuario.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_seleccion_usuario);
        editTextIdent = (EditText) findViewById(R.id.input_ident);
        botonIniciar = (Button) findViewById(R.id.iniciar_deposito);
        botonIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton ciudadano = (RadioButton) findViewById(R.id.radio_ciudadano);
                String identificador = editTextIdent.getText().toString();
                if (ciudadano.isChecked()) {

                    Intent intent = new Intent(SeleccionUsuario.this, Depositante.class);

                    intent.putExtra(EXTRA_MESSAGE, identificador);
                    intent.putExtra("from", "ciudadano");
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(SeleccionUsuario.this, DatosEmpresa.class);

                    intent.putExtra(EXTRA_MESSAGE, identificador);
                    startActivity(intent);
                }
            }
        });
        editTextIdent.addTextChangedListener(mTextEditorWatcher);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_ciudadano:
                if (checked) {
                    //PONER VISIBLE NIF
                    TextView textView = (TextView) findViewById(R.id.text_NIF);
                    textView.setVisibility(View.VISIBLE);

                    editTextIdent.setText("12345678");
                    editTextIdent.setHint("NIF");
                    //OCULTAR CIF
                    TextView textView1 = (TextView) findViewById(R.id.text_CIF);
                    textView1.setVisibility(View.GONE);
                    break;
                }
            case R.id.radio_empresa:
                if (checked)


                {
                    //PONER VISIBLE CIF
                    TextView textView = (TextView) findViewById(R.id.text_CIF);
                    textView.setVisibility(View.VISIBLE);
                    editTextIdent.setText("a1234567a");
                    editTextIdent.setHint("CIF");
                    //OCULTAR NIF
                    TextView textView1 = (TextView) findViewById(R.id.text_NIF);
                    textView1.setVisibility(View.GONE);
                    break;
                }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.seleccion_usuario, menu);
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
            Validador validador = new Validador();

            botonIniciar.setEnabled(true);
            /*
            if (editTextIdent.getHint().toString().equalsIgnoreCase("NIF"))

            {
                if (validador.validarNIF(s.toString())) {


                    botonIniciar.setEnabled(true);

                } else {

                    botonIniciar.setEnabled(false);
                }
            } else {
                if (validador.validarCIF(s.toString())) {


                    botonIniciar.setEnabled(true);
                } else {

                    botonIniciar.setEnabled(false);

                }
            }*/
        }


    };
}
