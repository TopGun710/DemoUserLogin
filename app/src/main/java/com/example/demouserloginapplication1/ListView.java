package com.example.demouserloginapplication1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class ListView extends AppCompatActivity {

    private ArrayList<User> userArrayList;
    private DatabaseHelper dbHandler;
    private ListAdapter listAdapter;
    private RecyclerView view;


    Button list_addbtn1, list_updatebtn1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainlist);

        // initializing our all variables.
        userArrayList = new ArrayList<>();
        dbHandler = new DatabaseHelper(ListView.this);

        // getting our course array
        // list from db handler class.
        userArrayList = dbHandler.ReadData();
        list_addbtn1 = findViewById(R.id.add_user);

        // on below line passing our array lost to our adapter class.
        listAdapter = new ListAdapter(userArrayList, ListView.this);
        view = findViewById(R.id.list_view);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ListView.this, RecyclerView.VERTICAL, false);
        view.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        view.setAdapter(listAdapter);

        list_addbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ListView.this,AddData_DB.class);
                startActivity(intent1);
            }
        });

//        list_updatebtn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v1) {
//
//
//            }
//        });

    }
}
