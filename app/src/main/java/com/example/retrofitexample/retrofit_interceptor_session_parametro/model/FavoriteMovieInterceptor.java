package com.example.retrofitexample.retrofit_interceptor_session_parametro.model;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class FavoriteMovieInterceptor implements Interceptor{
    @Override
    public Response intercept(Chain chain) throws IOException {


        Request original = chain.request();
        HttpUrl originalUrl = original.url();

        HttpUrl url = originalUrl.newBuilder()
                .addQueryParameter("api_key","58e6f701aa417b4b90fd02e9d85c1f42")
                .addQueryParameter("language","es-MX")
                .build();

        Request.Builder requestBuilder = original.newBuilder().url(url);
        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}
