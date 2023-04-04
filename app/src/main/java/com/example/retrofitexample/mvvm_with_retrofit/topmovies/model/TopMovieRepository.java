package com.example.retrofitexample.mvvm_with_retrofit.topmovies.model;

import com.example.retrofitexample.mvvm_with_retrofit.model.GetResponseMovies;
import com.example.retrofitexample.mvvm_with_retrofit.retrofit.CustomCallback;
import com.example.retrofitexample.mvvm_with_retrofit.retrofit.RetrofitMovieService;
import com.example.retrofitexample.mvvm_with_retrofit.retrofit.RetrofitService;

public class TopMovieRepository {

    private static TopMovieRepository instance;

    public static TopMovieRepository getInstance(){
        if(instance == null) instance = new TopMovieRepository();
        return instance;
    }

    public void downloadTopMovies(CustomCallback<GetResponseMovies> callback){
        RetrofitMovieService service = RetrofitService.getRetrofitInstance().create(RetrofitMovieService.class);
        service.getTopMovies().enqueue(callback);
    }
}
