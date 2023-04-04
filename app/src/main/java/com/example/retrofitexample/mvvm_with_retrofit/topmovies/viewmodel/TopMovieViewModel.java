package com.example.retrofitexample.mvvm_with_retrofit.topmovies.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.retrofitexample.mvvm_with_retrofit.model.GetResponseMovies;
import com.example.retrofitexample.mvvm_with_retrofit.model.Result;
import com.example.retrofitexample.mvvm_with_retrofit.retrofit.CustomCallback;
import com.example.retrofitexample.mvvm_with_retrofit.topmovies.model.TopMovieRepository;
import com.example.retrofitexample.mvvm_with_retrofit.utils.BaseViewModel;

import java.util.List;

public class TopMovieViewModel extends BaseViewModel {

    private TopMovieRepository repository;

    private MutableLiveData<List<Result>> topMoviesResult = new MutableLiveData<>();

    public TopMovieViewModel() {
        this.repository = TopMovieRepository.getInstance();
    }


    public void downloadTopMovies(){
        loading.postValue(true);
        repository.downloadTopMovies(new CustomCallback<GetResponseMovies>() {
            @Override
            public void onSuccess(GetResponseMovies response) {
                loading.postValue(false);
                topMoviesResult.postValue(response.getResults());
            }

            @Override
            public void onFailed(Throwable throwable) {
                loading.postValue(false);
                msgError.postValue(throwable.getMessage());
            }
        });
    }

    public LiveData<List<Result>> getTopMovieResult(){
        return topMoviesResult;
    }
}
