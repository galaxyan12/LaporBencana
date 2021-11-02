package com.kalbarprov.laporbencana.retrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL = "https://elaporbencana.kalbarprov.go.id/api/";
    private static Retrofit retrofit;
    TokenInterceptor tokenInterceptor = new TokenInterceptor();

    public static KabupatenInterface getKabupatenInterface(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(KabupatenInterface.class);
    }

    private static Retrofit getRetrofit(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .build();

        return retrofit;
    }

    public static LoginInterface getLoginInterface(){
        LoginInterface loginInterface = getRetrofit().create(LoginInterface.class);

        return loginInterface;
    }

}
