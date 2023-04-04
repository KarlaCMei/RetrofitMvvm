package com.example.retrofitexample.retrofit_call_back.model;

import android.app.Activity;
import android.app.ProgressDialog;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewCustomCallback<T> implements Callback<T> {
    private ProgressDialog progressDialog;

    public NewCustomCallback(Activity activity) {
        progressDialog =  new ProgressDialog(activity);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Cargando");
        progressDialog.setCanceledOnTouchOutside(true);
        progressDialog.show();
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if(progressDialog.isShowing()) progressDialog.dismiss();

    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        if(progressDialog.isShowing()) progressDialog.dismiss();

    }
}
