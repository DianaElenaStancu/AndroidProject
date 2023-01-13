package com.dian.amuseme.DiscoverJokes.DadJokesApi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/*
https://dad-jokes.p.rapidapi.com/joke/count
https://dad-jokes.p.rapidapi.com/random/joke?count=1
 */

public interface DadJokesApi {
    @Headers({
            "X-RapidAPI-Key: aad151b9d7msh4613eba551b16e9p12325ajsncc944fa4666d",
            "X-RapidAPI-Host: dad-jokes.p.rapidapi.com"
    })
    @GET("random/joke?count=5")
    Call<DadJokesApiResponse> getRandomJoke();
}
