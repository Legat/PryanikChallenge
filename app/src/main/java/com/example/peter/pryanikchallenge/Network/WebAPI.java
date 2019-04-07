package com.example.peter.pryanikchallenge.Network;



import com.example.peter.pryanikchallenge.models.Base;

import rx.Observable;
import retrofit2.http.GET;
import rx.Single;

public interface WebAPI {

    @GET("JSONSample.json")
    Single<Base> getBase();

}
