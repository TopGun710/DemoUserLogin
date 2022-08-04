package com.example.demouserloginapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationPage extends AppCompatActivity {

    EditText  editText_Name, editText_Password,editText_Email;
    Button register;

    SharedPreferences sharedPreferences;
    //Creating shared Pref name and the following variables
    public static final String SHARED_PREF_NAME = "LOGIN_PREF";
    public static final String KEY_NAME = "Name";
    public static final String KEY_EMAIL = "Email";
    public static final String KEY_PASSWORD = "Password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

       final TextView registration = (TextView)findViewById(R.id.RegToLogin);
        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Intent launchActivity1 = new Intent(RegistrationPage.this, LoginPage.class);
                startActivity(launchActivity1);
            }
        });

        editText_Email = findViewById(R.id.edit_Email);
        editText_Password = findViewById(R.id.edit_Password);
        editText_Name = findViewById(R.id.edit_Name);

        sharedPreferences=getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        register = findViewById(R.id.Registration);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_NAME, editText_Name.getText().toString());
                    editor.putString(KEY_EMAIL, editText_Email.getText().toString());
                    editor.putString(KEY_PASSWORD, editText_Password.getText().toString());
                    editor.commit();
                }catch (Exception E){
                    System.out.println(E.getStackTrace());
                }

                Toast.makeText(RegistrationPage.this,"REGISTRATION SUCCESSFUL",Toast.LENGTH_SHORT).show();
                finish();//finishes the activity

            }
        });


    }
}