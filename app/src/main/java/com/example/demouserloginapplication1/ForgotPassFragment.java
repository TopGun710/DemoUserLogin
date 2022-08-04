package com.example.demouserloginapplication1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

public class ForgotPassFragment extends AppCompatDialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        //Create the view
        View view =  LayoutInflater.from(getActivity()).inflate(R.layout.fragment_forgot_pass,null);
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                Log.i("Tag","The dialog button has been clicked");
            }
        };

        return new AlertDialog.Builder(getActivity())
                .setTitle("FORGOT PASSWORD")
                .setView(view)
                .setPositiveButton(android.R.string.ok, listener)
                .create();
    }
}