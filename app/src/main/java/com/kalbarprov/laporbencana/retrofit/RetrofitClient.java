package com.kalbarprov.laporbencana.retrofit;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL = "https://elaporbencana.kalbarprov.go.id/api/";
    public static Retrofit retrofit = null;

    public static Retrofit getRetrofit(){
        TokenInterceptor tokenInterceptor = new TokenInterceptor();
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(tokenInterceptor)
                .build();
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .client(client)
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }

    public static LoginInterface getLoginInterface(){

        return getRetrofit().create(LoginInterface.class);
    }

}
