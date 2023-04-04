package com.example.retrofitexample.retrofit_basico.model;

import com.example.retrofitexample.retrofit_basico.result_api.ResultsCharacters;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GitHubService {

    @GET("api/character/")
    Call<ResultsCharacters> getCharacters();
}
