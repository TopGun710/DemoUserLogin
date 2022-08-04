package com.example.demouserloginapplication1;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateUser extends AppCompatActivity {

    private EditText Update_name, Update_surname, Update_age, Update_phone, Update_address, Update_job, Update_qual, Update_Id;
    private Button updateUserbtn;
    private DatabaseHelper dbHandler;
    String UserName, UserSurname, UserAge, UserPhone;
    String UserAddress, UserJob, UserQualification;
    String UserId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);

        Update_Id = findViewById(R.id.editUpd3_EnrolId);
        Update_name = findViewById(R.id.editUpd3_Name);
        Update_surname = findViewById(R.id.editUpd3_Surname);
        Update_age = findViewById(R.id.editUpd3_Age);
        Update_phone = findViewById(R.id.editUpd3_Phone);
        Update_address = findViewById(R.id.editUpd3_PostalAddress);
        Update_job = findViewById(R.id.editUpd3_job);
        Update_qual = findViewById(R.id.editUpd3_Qualification);

        updateUserbtn = findViewById(R.id.btn_update);

        dbHandler = new DatabaseHelper(UpdateUser.this);

        UserName = getIntent().getStringExtra("name");
        UserSurname = getIntent().getStringExtra("surname");
        UserAge = getIntent().getStringExtra("age");
        UserPhone = getIntent().getStringExtra("phone_no");
        UserAddress = getIntent().getStringExtra("address");
        UserJob = getIntent().getStringExtra("job");
        UserQualification = getIntent().getStringExtra("qualification");
        UserId = getIntent().getStringExtra("id");


        // setting data to edit text
        // of our update activity.
        Update_name.setText(UserName);
        Update_surname.setText(UserSurname);
        Update_age.setText(UserAge);
        Update_phone.setText(UserPhone);
        Update_address.setText(UserAddress);
        Update_job.setText(UserJob);
        Update_qual.setText(UserQualification);
        Update_Id.setText(UserId);

        // adding on click listener to our update course button.
        updateUserbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // inside this method we are calling an update course
                // method and passing all our edit text values.
                dbHandler.updateCourse(
                        Update_name.getText().toString(), Update_surname.getText().toString(), Update_age.getText().toString(), Update_phone.getText().toString(), Update_address.getText().toString(), Update_job.getText().toString(), Update_qual.getText().toString(), Integer.parseInt(Update_Id.getText().toString())
                );

                Toast.makeText(UpdateUser.this, " User data Updated..", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(UpdateUser.this, ListView.class);
                startActivity(i);
            }
        });
    }
}