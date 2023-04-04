package com.example.retrofitexample.retrofit_interceptor.model;

import com.example.retrofitexample.retrofit_interceptor.result_api.MovieDBProject;

import retrofit2.Call;
import retrofit2.http.GET;

public interface InterceptorService {

    @GET("movie/popular")
    Call<MovieDBProject> getMovies();
}
