package com.example.retrofitexample.mvvm_with_retrofit.popularmovie.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.retrofitexample.R;
import com.example.retrofitexample.databinding.ActivityPopularMovieBinding;
import com.example.retrofitexample.mvvm_with_retrofit.model.Result;
import com.example.retrofitexample.mvvm_with_retrofit.popularmovie.viewmodel.PopularMovieViewModel;
import com.example.retrofitexample.mvvm_with_retrofit.utils.BaseActivity;

import java.util.List;

public class PopularMovieActivity extends BaseActivity<ActivityPopularMovieBinding,PopularMovieViewModel> {
    @NonNull
    @Override
    protected PopularMovieViewModel createViewModel() {
        return new ViewModelProvider(this).get(PopularMovieViewModel.class);
    }

    @NonNull
    @Override
    protected ActivityPopularMovieBinding createViewBinding(LayoutInflater layoutInflater) {
        return ActivityPopularMovieBinding.inflate(layoutInflater);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel.downloadPopularMovie();
        observers();
    }

    private void observers() {

        viewModel.getPopularMoviesResult().observe(this, new Observer<List<Result>>() {
            @Override
            public void onChanged(List<Result> results) {
                if(results !=null){
                    ArrayAdapter<Result> adapter = new ArrayAdapter(PopularMovieActivity.this, android.R.layout.simple_list_item_1,results);
                    ((ListView) findViewById(R.id.listResults)).setAdapter(adapter);
                }
            }
        });

    }
}