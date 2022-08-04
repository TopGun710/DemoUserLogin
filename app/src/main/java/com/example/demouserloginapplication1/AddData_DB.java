package com.example.demouserloginapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class AddData_DB extends AppCompatActivity {
    EditText user_Name, user_Surname, user_Age , user_TextId;
    EditText user_Phone, user_Qual, user_Address, user_Job;
    DatabaseHelper getdb;
    Button btnAddData, btnDisplayList;
    ImageView imageView;

    public static DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adduser);

        user_Name = (EditText)findViewById(R.id.editAdd3_Name);
        user_Surname = (EditText)findViewById(R.id.editAdd3_Surname);
        user_Age = (EditText)findViewById(R.id.editAdd3_Age);
        btnDisplayList = (Button)findViewById(R.id.btn_submit) ;
        user_Phone= (EditText)findViewById(R.id.editAdd3_Phone);
        user_Address = (EditText)findViewById(R.id.editAdd3_PostalAddress);
        user_Qual = (EditText)findViewById(R.id.editAdd3_Qualification);
        user_Job = (EditText)findViewById(R.id.editAdd3_job);
        user_TextId = (EditText)findViewById(R.id.editAdd3_EnrolId);

        btnAddData = (Button)findViewById(R.id.btn_submit);

        db = new DatabaseHelper(AddData_DB.this);


        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String UserName = user_Name.getText().toString();
                String UserSurname = user_Surname.getText().toString();
                String UserAge = user_Age.getText().toString();
                String UserContact = user_Phone.getText().toString();
                String UserAdddress = user_Address.getText().toString();
                String UserJob = user_Job.getText().toString();
                String UserQualification = user_Qual.getText().toString();
                int UserId = Integer.parseInt(user_TextId.getText().toString());

                // validating if the text fields are empty or not.
                if (UserName.isEmpty() && UserSurname.isEmpty() && UserAge.isEmpty() && UserContact.isEmpty()) {
                    Toast.makeText(AddData_DB.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                if(db.insertData(UserName, UserSurname, UserAge, UserContact, UserAdddress, UserJob, UserQualification)){
                    Intent i = new Intent(AddData_DB.this, ListView.class);
                    startActivity(i);
                }
                // after adding the data we are displaying a toast message.
                Toast.makeText(AddData_DB.this, "Data has been added.", Toast.LENGTH_SHORT).show();
                user_Name.setText("");
                user_Surname.setText("");
                user_Age.setText("");
                user_Phone.setText("");
                user_Address.setText("");
                user_Job.setText("");
                user_Qual.setText("");

            }

        });

    }


}











