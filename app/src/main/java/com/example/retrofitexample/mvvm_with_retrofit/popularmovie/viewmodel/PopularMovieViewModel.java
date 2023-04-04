package com.example.retrofitexample.mvvm_with_retrofit.popularmovie.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.retrofitexample.mvvm_with_retrofit.model.GetResponseMovies;
import com.example.retrofitexample.mvvm_with_retrofit.model.Result;
import com.example.retrofitexample.mvvm_with_retrofit.popularmovie.model.PopularMovieRepository;
import com.example.retrofitexample.mvvm_with_retrofit.retrofit.CustomCallback;
import com.example.retrofitexample.mvvm_with_retrofit.utils.BaseViewModel;

import java.util.List;

public class PopularMovieViewModel extends BaseViewModel {
    private PopularMovieRepository repository;
    private MutableLiveData<List<Result>> popularMovieResult = new MutableLiveData<>();

    public PopularMovieViewModel() {
        repository = PopularMovieRepository.getInstance();
    }

    public void downloadPopularMovie() {
        loading.postValue(true);
        repository.downloadPopularMovies(new CustomCallback<GetResponseMovies>() {
            @Override
            public void onSuccess(GetResponseMovies response) {
                loading.postValue(false);
                popularMovieResult.postValue(response.getResults());
            }

            @Override
            public void onFailed(Throwable throwable) {
                msgError.postValue(throwable.getMessage());
                loading.postValue(false);
            }
        });
    }

    public LiveData<List<Result>> getPopularMoviesResult(){
        return popularMovieResult;
    }

}
