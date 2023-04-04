package com.example.retrofitexample.retrofit_interceptor_session_parametro.model;

import com.example.retrofitexample.retrofit_interceptor_session_parametro.adapter.RetrofitSesion;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface InterceptorServiceSesion {
    @GET("account/17934533/favorite/movies")
    Call<RetrofitSesion> getFavoriteMovies(@Query("session_id")String session_id);
}
