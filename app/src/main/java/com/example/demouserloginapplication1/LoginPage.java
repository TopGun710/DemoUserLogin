package com.example.demouserloginapplication1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.SharedPreferences;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "LOGIN_PREF";

    String email,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //Text redirect. signup textview should be created within mainActivity.xml

        final TextView registration = (TextView)findViewById(R.id.Registration);
        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Intent launchActivity1 = new Intent(LoginPage.this, RegistrationPage.class);
                startActivity(launchActivity1);
            }
        });


        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        email = (sharedPreferences.getString(RegistrationPage.KEY_EMAIL, ""));
        Log.d("email","this is email"+email);
        pass = (sharedPreferences.getString(RegistrationPage.KEY_PASSWORD, ""));
        Log.d("pass",pass);

        EditText log_email = (EditText) findViewById(R.id.editLogin_Email);
        EditText log_pass = (EditText)findViewById(R.id.editLogin_Password);


        Button btn_login = findViewById(R.id.Login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("TAG", "onClick: btn_login on clicked");

                String Log_email = log_email.getText().toString();
                String Log_pass = log_pass.getText().toString();
                if(Log_email.isEmpty()){
                    Toast.makeText(LoginPage.this,"Email field cannot be empty",Toast.LENGTH_SHORT).show();
                    log_email.setError("Email cannot be empty");
                }
                else if(Log_pass.isEmpty()){
                    Toast.makeText(LoginPage.this,"Password field cannot be empty",Toast.LENGTH_SHORT).show();
                    log_pass.setError("Password can't be empty");
                }
                else{
                    log_email.setError(null);
                    log_pass.setError(null);
                }
                Toast.makeText(LoginPage.this,"Login Successful",Toast.LENGTH_SHORT).show();

                /*Intent intent2 = new Intent(LoginPage.this, AddData_DB.class);
                startActivity(intent2);*/

                if(Log_email.equalsIgnoreCase(email) && Log_pass.equalsIgnoreCase(pass)){

                    Intent intent2 = new Intent(LoginPage.this, AddData_DB.class);
                    startActivity(intent2);

                }

            }
        });

        setupSetMessage();
    }

    private void setupSetMessage(){
        final TextView forgpass = (TextView) findViewById(R.id.textForgotPass);
        forgpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getSupportFragmentManager();
                ForgotPassFragment dialog = new ForgotPassFragment();
                dialog.show(manager,"message dialog");

                Log.i("tag","Just showed the dialog");
            }
        });
    }
}