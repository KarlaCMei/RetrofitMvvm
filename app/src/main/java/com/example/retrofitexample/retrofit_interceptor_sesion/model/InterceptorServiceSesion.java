package com.example.retrofitexample.retrofit_interceptor_sesion.model;

import com.example.retrofitexample.retrofit_interceptor_sesion.result_api.RetrofitSesion;

import retrofit2.Call;
import retrofit2.http.GET;

public interface InterceptorServiceSesion {
    @GET("account/17934533/favorite/movies")
    Call<RetrofitSesion> getFavoriteMovies();
}
