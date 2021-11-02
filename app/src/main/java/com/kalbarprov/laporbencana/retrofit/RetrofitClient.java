package com.kalbarprov.laporbencana.retrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL = "https://elaporbencana.kalbarprov.go.id/api/";
    private static Retrofit retrofit = null;
    TokenInterceptor tokenInterceptor = new TokenInterceptor();

    public static KabupatenInterface getKabupatenInterface(){

        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(KabupatenInterface.class);
    }

    private static Retrofit getRetrofit(){

        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }

    public static LoginInterface getLoginInterface(){
        LoginInterface loginInterface = getRetrofit().create(LoginInterface.class);

        return loginInterface;
    }

}
