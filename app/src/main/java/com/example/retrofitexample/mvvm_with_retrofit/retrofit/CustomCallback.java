package com.example.retrofitexample.mvvm_with_retrofit.retrofit;

import androidx.annotation.NonNull;

import java.net.UnknownHostException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class CustomCallback<T> implements Callback<T> {

    @Override
    public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
        if(response.isSuccessful() && response.body() !=null){
            onSuccess(response.body());
        }else{
            onFailed(new Throwable(response.message()));
        }

    }

    @Override
    public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
        if(t instanceof UnknownHostException){
            onFailed(new Throwable("No hay conexión"));
        }else {
            onFailed(t);
        }

    }


    public abstract void onSuccess(T response);

    public abstract void onFailed(Throwable throwable);
}
