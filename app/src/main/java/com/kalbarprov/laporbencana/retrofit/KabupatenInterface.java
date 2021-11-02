package com.kalbarprov.laporbencana.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface KabupatenInterface {

    @GET("/get_kabupaten/1")
    Call<List<GetKabupaten>> getKabupatenData();

}
