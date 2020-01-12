package com.vaj.vmovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {

                      startActivity(new Intent(MainActivity.this,HomeActivity.class));

                        finish();

                    }
                }
                , 1000);


    }
}
