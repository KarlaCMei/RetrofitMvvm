package com.example.retrofitexample.mvvm_with_retrofit.retrofit;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class MovieInterceptor  implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        HttpUrl originalUrl = original.url();

        HttpUrl url = originalUrl.newBuilder()
                .addQueryParameter("api_key","0a1921175060ab8cb0a622f0bc4ea651")
                .addQueryParameter("language","es-MX")
                .build();
        Request.Builder requestBuilder = original.newBuilder().url(url);
        Request request = requestBuilder.build();

        return chain.proceed(request);
    }
}
