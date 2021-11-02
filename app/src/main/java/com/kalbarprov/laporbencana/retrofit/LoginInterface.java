package com.kalbarprov.laporbencana.retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginInterface {

    @POST("/login")
    Call<LoginResponse> userLogin(@Body LoginRequest loginRequest);

}
