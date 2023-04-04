package com.example.retrofitexample.retrofit_time;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface TimeService {
    @GET("404?sleep=5000")
    Call<ResponseBody> getTime();
}
