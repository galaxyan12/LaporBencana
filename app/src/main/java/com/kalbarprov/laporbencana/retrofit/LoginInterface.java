package com.kalbarprov.laporbencana.retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginInterface {

    @FormUrlEncoded
    @POST("/login")
    Call<LoginResponse> userLogin(@Field("username") String username,
                                  @Field("password") String password);

}
