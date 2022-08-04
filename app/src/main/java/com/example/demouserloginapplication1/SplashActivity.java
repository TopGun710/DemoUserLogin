package com.example.demouserloginapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity{
        Window window ;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            window=getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            super.onCreate(savedInstanceState);
            setContentView(R.layout.splashfile);
            getSupportActionBar().hide();
            Thread thread=new Thread(){

                @Override
                public void run()
                {
                    try {
                        sleep( 2000);
                        startActivity(new Intent(getApplicationContext(), LoginPage.class));
                        finish();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    super.run();
                }

            };
            thread.start();
        }
}



