package com.dani.ecoparque;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

public class DesconectarFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.confirmacion)
                .setPositiveButton(R.string.si, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        Intent intentDesconectar = new Intent(getActivity(), LoginActivity.class);
                        intentDesconectar.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        intentDesconectar.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        intentDesconectar.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intentDesconectar);
                        getActivity().finish();
                    }
                })
                .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dismiss();
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}