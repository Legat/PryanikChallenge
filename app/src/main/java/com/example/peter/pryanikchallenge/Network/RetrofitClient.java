package com.example.peter.pryanikchallenge.Network;

import android.support.annotation.NonNull;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public static final String BASE_URL = "https://prnk.blob.core.windows.net/tmp/";


    @NonNull
    private static Retrofit getRetrofitInstance(){
      return new Retrofit.Builder()
               .addConverterFactory(GsonConverterFactory.create())
               .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
               .baseUrl(BASE_URL)
               .build();
    }

    public static WebAPI getApiService(){
        return getRetrofitInstance().create(WebAPI.class);
    }
}
