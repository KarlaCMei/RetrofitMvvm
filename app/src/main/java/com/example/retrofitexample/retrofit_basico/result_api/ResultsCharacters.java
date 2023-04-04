
package com.example.retrofitexample.retrofit_basico.result_api;

import java.util.List;

import com.example.retrofitexample.retrofit_basico.result_api.apicharacter.Info;
import com.example.retrofitexample.retrofit_basico.result_api.apicharacter.Result;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultsCharacters {

    @SerializedName("info")
    @Expose
    private Info info;
    @SerializedName("results")
    @Expose
    private List<Result> results;

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

}
