package com.example.retrofitexample.mvvm_with_retrofit.utils;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BaseViewModel extends ViewModel {
    public MutableLiveData<Boolean> loading = new MutableLiveData<>();
    public MutableLiveData<String> msgError = new MutableLiveData<>();
}
