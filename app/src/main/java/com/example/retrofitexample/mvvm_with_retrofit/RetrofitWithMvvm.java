package com.example.retrofitexample.mvvm_with_retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.retrofitexample.R;
import com.example.retrofitexample.mvvm_with_retrofit.popularmovie.view.PopularMovieActivity;
import com.example.retrofitexample.mvvm_with_retrofit.topmovies.view.TopMovieActivity;

public class RetrofitWithMvvm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_with_mvvm);


        findViewById(R.id.btnPopular).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RetrofitWithMvvm.this,PopularMovieActivity.class));
            }
        });

        findViewById(R.id.btnTop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RetrofitWithMvvm.this, TopMovieActivity.class));
            }
        });

    }
}