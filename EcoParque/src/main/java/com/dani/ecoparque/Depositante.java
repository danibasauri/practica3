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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class Depositante extends Activity {

    private EditText ident, peso;
    private Button btnDep;
    private String from;
    private CheckBox material, aceites, neveras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_depositante);

        Intent intent = getIntent();
        String message = intent.getStringExtra(SeleccionUsuario.EXTRA_MESSAGE);
        from = intent.getStringExtra("from");
        ident = (EditText) findViewById(R.id.dep_ident);
        ident.setText(message);


        peso = (EditText) findViewById(R.id.text_peso);
        btnDep = (Button) findViewById(R.id.depositar);

        btnDep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Depositante.this, Resultados.class);
                intent.putExtra(SeleccionUsuario.EXTRA_MESSAGE, ident.getText().toString());
                if (material.isChecked())
                    intent.putExtra("matInf", "true");
                else
                    intent.putExtra("matInf", "false");
                if (neveras.isChecked())
                    intent.putExtra("neveras", "true");
                else
                    intent.putExtra("neveras", "false");

                if (aceites.isChecked())
                    intent.putExtra("aceites", "true");
                else
                    intent.putExtra("aceites", "false");
                intent.putExtra("peso", peso.getText().toString());
                intent.putExtra("from", from);
                startActivity(intent);
            }
        });

        material = (CheckBox) findViewById(R.id.dep_chk_matInf);
        aceites = (CheckBox) findViewById(R.id.dep_chk_aceites);
        neveras = (CheckBox) findViewById(R.id.dep_chk_nev);

        peso.addTextChangedListener(mTextEditorWatcher);
        material.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    peso.setEnabled(true);

                } else if (!aceites.isChecked() && !neveras.isChecked()) {
                    btnDep.setEnabled(false);
                    peso.setText("");
                    peso.setEnabled(false);
                }

            }
        });

        aceites.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    peso.setEnabled(true);
                } else if (!material.isChecked() && !neveras.isChecked()) {
                    btnDep.setEnabled(false);
                    peso.setText("");
                    peso.setEnabled(false);
                }
            }
        });

        neveras.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    peso.setEnabled(true);
                } else if (!aceites.isChecked() && !material.isChecked()) {
                    btnDep.setEnabled(false);
                    peso.setText("");
                    peso.setEnabled(false);
                }
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.depositante, menu);
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

            if (!peso.getText().toString().isEmpty())
                btnDep.setEnabled(true);
            else
                btnDep.setEnabled(false);
        }


    };


}
