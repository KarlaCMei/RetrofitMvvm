package com.example.retrofitexample.retrofit_interceptor_sesion.model;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.retrofitexample.R;
import com.example.retrofitexample.retrofit_interceptor_sesion.result_api.RetrofitSesion;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInterceptorSesionActivity extends AppCompatActivity {
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_interceptor_sesion);
        listView = findViewById(R.id.listFavotitesMovies);

        getResultFavoritesMovies();
    }

    private void getResultFavoritesMovies() {
        OkHttpClient httpClient =  new OkHttpClient.Builder().addInterceptor(new FavoriteMovieInterceptor())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();
        InterceptorServiceSesion service = retrofit.create(InterceptorServiceSesion.class);
        Call<RetrofitSesion> repos = service.getFavoriteMovies();

        repos.enqueue(new Callback<RetrofitSesion>() {
            @Override
            public void onResponse(Call<RetrofitSesion> call, Response<RetrofitSesion> response) {

               ArrayAdapter adapterMovie = new ArrayAdapter(RetrofitInterceptorSesionActivity.this, R.layout.spinner_item,response.body().getResultSesion());
                listView.setAdapter(adapterMovie);
                Log.e("Nombre","Favorite Movie Name " + response.body().getResultSesion());

            }

            @Override
            public void onFailure(Call<RetrofitSesion> call, Throwable t) {
                Log.e("Error","Error" + t.getMessage());
                Toast.makeText(RetrofitInterceptorSesionActivity.this, "Error al cargar las peliculas", Toast.LENGTH_LONG).show();
            }
        });

    }

}