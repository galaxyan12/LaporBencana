package com.kalbarprov.laporbencana;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.kalbarprov.laporbencana.retrofit.LoginRequest;
import com.kalbarprov.laporbencana.retrofit.LoginModel;
import com.kalbarprov.laporbencana.retrofit.RetrofitClient;
import com.kalbarprov.laporbencana.retrofit.SharedPrefs;
import com.kalbarprov.laporbencana.retrofit.TokenInterceptor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button btnLogin;
    ProgressBar progressBar;
    public static Context appContext;
    public static Context getAppContext(){
        return appContext;
    }
    public String bearerToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.editTextTextPassword);
        progressBar = findViewById(R.id.progressBarLogin);
        appContext = getApplicationContext();
        if (ContextCompat.checkSelfPermission(LoginActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(LoginActivity.this, new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION
            }, 100);
        }
        btnLogin = findViewById(R.id.buttonLogin);
        btnLogin.setOnClickListener(v -> {
            progressBar.setVisibility(View.VISIBLE);
            if(TextUtils.isEmpty(username.getText().toString()) || TextUtils.isEmpty(password.getText().toString())){
                Toast.makeText(LoginActivity.this, "Masukkan Username & Password", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            } else {
                doLogin();
            }
        });
    }

    private void doLogin() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(username.getText().toString());
        loginRequest.setPassword(password.getText().toString());
        Call<LoginModel> loginResponseCall = RetrofitClient.getLoginInterface().userLogin(loginRequest.getUsername(),loginRequest.getPassword());
        loginResponseCall.enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                if(response.isSuccessful()){
                    Toast.makeText(LoginActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(() -> {
                        bearerToken = response.body().getToken();
                        SharedPrefs sharedPrefs = new SharedPrefs();
                        sharedPrefs.savedPreferences(LoginActivity.this, "token", bearerToken);
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.putExtra("token", bearerToken);
                        startActivity(intent);
                        finish();
                        progressBar.setVisibility(View.GONE);
                    }, 700);
                } else {
                    Toast.makeText(LoginActivity.this, "Login Gagal "+response.toString(), Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Failure " +t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("debug", "error : " + t.getMessage());
            }
        });
    }
}