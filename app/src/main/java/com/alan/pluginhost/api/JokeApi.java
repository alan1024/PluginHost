package com.alan.pluginhost.api;

import android.database.Observable;

import com.alan.pluginhost.model.Joke;

import retrofit.http.GET;
import retrofit.http.Query;


public interface JokeApi {

    @GET(ApiConst.JOKE_JOKE)
    Observable<Joke.JokeData> joke(@Query("a") String a, @Query("p") int page);

}
