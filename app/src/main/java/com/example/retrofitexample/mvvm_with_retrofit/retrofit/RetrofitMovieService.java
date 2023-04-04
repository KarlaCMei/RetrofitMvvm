package com.example.retrofitexample.mvvm_with_retrofit.retrofit;

import com.example.retrofitexample.mvvm_with_retrofit.model.GetResponseMovies;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitMovieService {

    @GET("movie/popular")
    Call<GetResponseMovies> getPopularMovies();

    @GET("movie/top_rated")
    Call<GetResponseMovies> getTopMovies();

}
