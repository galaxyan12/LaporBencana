package com.kalbarprov.laporbencana;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.kalbarprov.laporbencana.dialog.TambahDialog;
import com.kalbarprov.laporbencana.retrofit.GetKabupaten;
import com.kalbarprov.laporbencana.retrofit.KabupatenAdapter;
import com.kalbarprov.laporbencana.retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ImageView floatAction;
    RecyclerView recyclerView;
    ProgressBar progressBar;
    LinearLayoutManager layoutManager;
    KabupatenAdapter kabupatenAdapter;
    List<GetKabupaten> getKabupatenList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);
        layoutManager = new LinearLayoutManager(this);

        floatAction = findViewById(R.id.float_Action);
        floatAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

        recyclerView.setLayoutManager(layoutManager);
        kabupatenAdapter = new KabupatenAdapter(getKabupatenList);
        recyclerView.setAdapter(kabupatenAdapter);

        fetchData();

    }

    public void openDialog(){
        TambahDialog tambahDialog = new TambahDialog();
        tambahDialog.show(getSupportFragmentManager(), "Lapor Bencana");
    }

    private void fetchData(){
        progressBar.setVisibility(View.VISIBLE);
        RetrofitClient.getKabupatenInterface().getKabupatenData().enqueue(new Callback<List<GetKabupaten>>() {
            @Override
            public void onResponse(Call<List<GetKabupaten>> call, Response<List<GetKabupaten>> response) {
                if (response.isSuccessful() && response.body() != null){
                    getKabupatenList.addAll(response.body());
                    kabupatenAdapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<List<GetKabupaten>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "Error : " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}