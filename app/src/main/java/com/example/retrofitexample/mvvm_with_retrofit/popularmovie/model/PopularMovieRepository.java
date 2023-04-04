package com.example.retrofitexample.mvvm_with_retrofit.popularmovie.model;

import com.example.retrofitexample.mvvm_with_retrofit.model.GetResponseMovies;
import com.example.retrofitexample.mvvm_with_retrofit.retrofit.CustomCallback;
import com.example.retrofitexample.mvvm_with_retrofit.retrofit.RetrofitMovieService;
import com.example.retrofitexample.mvvm_with_retrofit.retrofit.RetrofitService;

public class PopularMovieRepository {
    private static PopularMovieRepository instance;

    public static PopularMovieRepository getInstance() {
        if (instance == null) instance = new PopularMovieRepository();
        return instance;
    }

    public void downloadPopularMovies(CustomCallback<GetResponseMovies> callback){
        RetrofitMovieService service = RetrofitService.getRetrofitInstance().create(RetrofitMovieService.class);
        service.getPopularMovies().enqueue(callback);
    }
}
