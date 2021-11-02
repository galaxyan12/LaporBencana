package com.kalbarprov.laporbencana.retrofit;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class TokenInterceptor implements Interceptor {

    public static String tokenval;

    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request newRequest = chain.request().newBuilder()
                .header("Authorization","Bearer " + tokenval)
                .build();

        return chain.proceed(newRequest);
    }
}
