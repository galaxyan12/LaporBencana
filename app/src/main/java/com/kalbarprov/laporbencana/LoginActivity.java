package com.kalbarprov.laporbencana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.kalbarprov.laporbencana.retrofit.LoginRequest;
import com.kalbarprov.laporbencana.retrofit.LoginResponse;
import com.kalbarprov.laporbencana.retrofit.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button btnLogin;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.editTextTextPassword);
        progressBar = findViewById(R.id.progressBarLogin);
        btnLogin = findViewById(R.id.buttonLogin);
        btnLogin.setOnClickListener(v -> {
            progressBar.setVisibility(View.VISIBLE);
            if(TextUtils.isEmpty(username.getText().toString()) || TextUtils.isEmpty(password.getText().toString())){
                Toast.makeText(LoginActivity.this, "Masukkan Username & Password", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            } else {
                doLogin();
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    private void doLogin() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(username.getText().toString());
        loginRequest.setPassword(password.getText().toString());
        Call<LoginResponse> loginResponseCall = RetrofitClient.getLoginInterface().userLogin(loginRequest.getUsername(), loginRequest.getPassword());
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful()){
                    Toast.makeText(LoginActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(() -> {
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    }, 700);
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Failure " +t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}