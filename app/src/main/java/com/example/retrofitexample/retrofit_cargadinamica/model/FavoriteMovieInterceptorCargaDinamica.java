package com.example.retrofitexample.retrofit_cargadinamica.model;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class FavoriteMovieInterceptorCargaDinamica implements Interceptor{
    @Override
    public Response intercept(Chain chain) throws IOException {


        Request original = chain.request();
        HttpUrl originalUrl = original.url();

        HttpUrl url = originalUrl.newBuilder()
                .addQueryParameter("api_key","58e6f701aa417b4b90fd02e9d85c1f42")
                .addQueryParameter("language","es-MX")
                .addQueryParameter("session_id", "34ece23964819114d4a8ef466d4af0412ca61d58")
                .build();

        Request.Builder requestBuilder = original.newBuilder().url(url);
        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}
