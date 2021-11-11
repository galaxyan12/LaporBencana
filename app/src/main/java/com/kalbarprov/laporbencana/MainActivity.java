package com.kalbarprov.laporbencana;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kalbarprov.laporbencana.dialog.TambahDialog;
import com.kalbarprov.laporbencana.retrofit.Laporan;
import com.kalbarprov.laporbencana.retrofit.LaporanAdapter;
import com.kalbarprov.laporbencana.retrofit.LaporanModel;
import com.kalbarprov.laporbencana.retrofit.RetrofitClient;
import com.kalbarprov.laporbencana.retrofit.SharedPrefs;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private String token;
    private ImageView floatAction;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adLaporan;
    private ProgressBar progressBar;
    private RecyclerView.LayoutManager layoutManager;
    public List<Laporan> laporanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);
        layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        floatAction = findViewById(R.id.float_Action);
        floatAction.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TambahActivity.class);
            startActivity(intent);
        });
        fetchDataLapor();
    }

    public void openDialog(){
        TambahDialog tambahDialog = new TambahDialog();
        tambahDialog.show(getSupportFragmentManager(), "Lapor Bencana");
    }

    private void  fetchDataLapor(){
        progressBar.setVisibility(View.VISIBLE);
        token = getIntent().getStringExtra("token");
        Call<LaporanModel> laporanModelCall = RetrofitClient.getLoginInterface().getLaporanData("Bearer "+token);
        laporanModelCall.enqueue(new Callback<LaporanModel>() {
            @Override
            public void onResponse(Call<LaporanModel> call, Response<LaporanModel> response) {
                laporanList = response.body().getLaporan();
                adLaporan = new LaporanAdapter(MainActivity.this, laporanList);
                progressBar.setVisibility(View.GONE);
                recyclerView.setAdapter(adLaporan);
                adLaporan.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<LaporanModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Gagal mengambil data : "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}