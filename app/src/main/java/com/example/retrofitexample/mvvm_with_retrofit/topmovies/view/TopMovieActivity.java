package com.example.retrofitexample.mvvm_with_retrofit.topmovies.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.retrofitexample.R;
import com.example.retrofitexample.databinding.ActivityTopMovieBinding;
import com.example.retrofitexample.mvvm_with_retrofit.model.Result;
import com.example.retrofitexample.mvvm_with_retrofit.topmovies.viewmodel.TopMovieViewModel;
import com.example.retrofitexample.mvvm_with_retrofit.utils.BaseActivity;

import java.util.List;

public class TopMovieActivity extends BaseActivity<ActivityTopMovieBinding, TopMovieViewModel> {
    @NonNull
    @Override
    protected TopMovieViewModel createViewModel() {
        return new ViewModelProvider(this).get(TopMovieViewModel.class);
    }

    @NonNull
    @Override
    protected ActivityTopMovieBinding createViewBinding(LayoutInflater layoutInflater) {
        return ActivityTopMovieBinding.inflate(layoutInflater);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel.downloadTopMovies();
        observers();
    }

    private void observers() {

        viewModel.getTopMovieResult().observe(this, new Observer<List<Result>>() {
            @Override
            public void onChanged(List<Result> results) {
                if(results !=null){
                    ArrayAdapter<Result> adapter = new ArrayAdapter(TopMovieActivity.this, android.R.layout.simple_list_item_1,results);
                    ((ListView) findViewById(R.id.listResults)).setAdapter(adapter);
                }
            }
        });

    }
}