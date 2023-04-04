package com.example.retrofitexample.retrofit_interceptor.model;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.retrofitexample.R;
import com.example.retrofitexample.retrofit_interceptor.result_api.MovieDBProject;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInterceptorActivity extends AppCompatActivity{
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_interceptor);
        listView = findViewById(R.id.listMovies);

        getRestultCharacter();
    }

    private void getRestultCharacter() {
        OkHttpClient httpClient =  new OkHttpClient.Builder().addInterceptor(new MovieInterceptor())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();
        InterceptorService service = retrofit.create(InterceptorService.class);
        Call<MovieDBProject> repos = service.getMovies();

        repos.enqueue(new Callback<MovieDBProject>() {
            @Override
            public void onResponse(Call<MovieDBProject> call, Response<MovieDBProject> response) {
                ArrayAdapter adapterMovie = new ArrayAdapter(RetrofitInterceptorActivity.this, R.layout.spinner_item,response.body().getResults());
                listView.setAdapter(adapterMovie);
                Log.e("Nombre","Movie Name" + response.body() );

            }

            @Override
            public void onFailure(Call<MovieDBProject> call, Throwable t) {
                Log.e("Error","Error" + t.getMessage());
                Toast.makeText(RetrofitInterceptorActivity.this, "Error al cargar las peliculas", Toast.LENGTH_LONG).show();
            }
        });
        //Call<List<ResultMovies>> repos = service.getMovies();

        /*repos.enqueue(new Callback<List<ResultMovies>>() {
            @Override
            public void onResponse(Call<List<ResultMovies>> call, Response<List<ResultMovies>> response) {
                CharacterInterceptor interceptor = new CharacterInterceptor();
                ArrayAdapter adapterMovies = new ArrayAdapter(RetrofitInterceptorActivity.this, R.layout.spinner_item,response.body());
                listView.setAdapter(adapterMovies);


            }

            @Override
            public void onFailure(Call<List<ResultMovies>> call, Throwable t) {
                Log.e("Error","Error" + t.getMessage());
                Toast.makeText(RetrofitInterceptorActivity.this, "Error al cargar las peliculas", Toast.LENGTH_LONG).show();
            }
        });*/


    }



}