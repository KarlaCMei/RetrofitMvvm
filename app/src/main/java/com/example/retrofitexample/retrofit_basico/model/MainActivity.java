package com.example.retrofitexample.retrofit_basico.model;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.retrofitexample.R;
import com.example.retrofitexample.retrofit_basico.adapter.CharacterAdapter;
import com.example.retrofitexample.retrofit_basico.result_api.apicharacter.Result;
import com.example.retrofitexample.retrofit_basico.result_api.ResultsCharacters;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private List<Result> listCharacters;
    private RecyclerView recyclerView;
    private CharacterAdapter adapterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.list_character);
        getRestultCharacter();



    }
        private void getRestultCharacter(){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://rickandmortyapi.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            GitHubService service = retrofit.create(GitHubService.class);
            Call<ResultsCharacters> repos = service.getCharacters();

            repos.enqueue(new Callback<ResultsCharacters>() {
                @Override
                public void onResponse(Call<ResultsCharacters> call, Response<ResultsCharacters> response) {
                    if(response.isSuccessful()){
                        listCharacters = response.body().getResults();
                        adapterList = new CharacterAdapter(listCharacters);
                        recyclerView.setAdapter(adapterList);
                    }
                }

                @Override
                public void onFailure(Call<ResultsCharacters> call, Throwable t) {
                    Log.e("Error","Error" + t.getMessage());
                    Toast.makeText(MainActivity.this, "Error al cargar los personajes", Toast.LENGTH_LONG).show();
                }
            });

        }


}