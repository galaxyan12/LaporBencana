package com.kalbarprov.laporbencana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            startActivity(new Intent(SplashScreenActivity.this, LoginActivity.class));
            finish();
        }, 3000);
    }
}